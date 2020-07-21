package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.model.Product;

public interface ProductDAO {
	List<Product> list();
}