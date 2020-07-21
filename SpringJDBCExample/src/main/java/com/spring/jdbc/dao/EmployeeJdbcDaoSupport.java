package com.spring.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.spring.jdbc.model.Employee;

public class EmployeeJdbcDaoSupport extends JdbcDaoSupport implements
		EmployeeDAO {

	@Override
	public void save(Employee employee) {
		String query = "insert into Employee (id, name, role) values (?,?,?)";

		JdbcTemplate jdbcTemplate = getJdbcTemplate();

		Object[] args = new Object[] { employee.getId(), employee.getName(),
				employee.getRole() };

		int out = jdbcTemplate.update(query, args);

		if (out != 0) {
			System.out.println("Employee saved with id=" + employee.getId());
		} else
			System.out.println("Employee save failed with id="
					+ employee.getId());

		// Batch Update using JdbcTemplate for list of Employees
		final List<Employee> tEmpList = new ArrayList<>();
		tEmpList.add(employee);
		getJdbcTemplate().batchUpdate(query,
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						Employee customer = tEmpList.get(i);
						ps.setLong(1, customer.getId());
						ps.setString(2, customer.getName());
						ps.setString(3, customer.getRole());
					}

					@Override
					public int getBatchSize() {
						return tEmpList.size();
					}
				});
	}

	@Override
	public Employee getById(int id) {
		String query = "select id, name, role from Employee where id = ?";
		JdbcTemplate jdbcTemplate = getJdbcTemplate();

		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[] { id },
				new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Employee emp = new Employee();
						emp.setId(rs.getInt("id"));
						emp.setName(rs.getString("name"));
						emp.setRole(rs.getString("role"));
						return emp;
					}
				});

		return emp;
	}

	@Override
	public void update(Employee employee) {
		String query = "update Employee set name=?, role=? where id=?";
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		Object[] args = new Object[] { employee.getName(), employee.getRole(),
				employee.getId() };

		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("Employee updated with id=" + employee.getId());
		} else
			System.out.println("No Employee found with id=" + employee.getId());
	}

	@Override
	public void deleteById(int id) {

		String query = "delete from Employee where id=?";
		JdbcTemplate jdbcTemplate = getJdbcTemplate();

		int out = jdbcTemplate.update(query, id);
		if (out != 0) {
			System.out.println("Employee deleted with id=" + id);
		} else
			System.out.println("No Employee found with id=" + id);
	}

	@Override
	public List<Employee> getAll() {
		String query = "select id, name, role from Employee";
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String, Object>> empRows = jdbcTemplate.queryForList(query);

		for (Map<String, Object> empRow : empRows) {
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setName(String.valueOf(empRow.get("name")));
			emp.setRole(String.valueOf(empRow.get("role")));
			empList.add(emp);
		}
		return empList;
	}

}
