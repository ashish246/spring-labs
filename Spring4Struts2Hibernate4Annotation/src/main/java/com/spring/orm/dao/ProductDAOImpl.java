package com.spring.orm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.model.Product;

public class ProductDAOImpl implements ProductDAO {
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Product> list() {

		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) sessionFactory
				.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listProduct;
	}
}