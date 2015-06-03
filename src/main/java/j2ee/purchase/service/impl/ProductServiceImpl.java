package j2ee.purchase.service.impl;

import j2ee.purchase.dao.ProductDAO;
import j2ee.purchase.model.Product;
import j2ee.purchase.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public void addProduct(Product product) {
		productDAO.addProduct(product);

	}

	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);

	}

	@Override
	public List<Product> lstProducts() {
		return productDAO.lstProduct();
	}

	@Override
	public Product getProductById(String id) {
		return productDAO.getProductById(id);
	}

	@Override
	public void removeProduct(String id) {
		productDAO.removeProduct(id);
	}

}
