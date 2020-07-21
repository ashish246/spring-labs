package com.spring.orm.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.spring.orm.dao.ProductDAO;
import com.spring.orm.model.Product;

public class ListProductAction extends ActionSupport {

	private ProductDAO productDAO;
	private List<Product> listProduct;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public String execute() {
		listProduct = productDAO.list();
		return SUCCESS;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}
}