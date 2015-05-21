package j2ee.purchase.supplier.service.impl;

import j2ee.purchase.supplier.dao.ProductDAO;
import j2ee.purchase.supplier.model.Product;
import j2ee.purchase.supplier.service.ProductService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		productDAO.addProduct(product);

	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);

	}

	@Override
	@Transactional
	public List<Product> lstProducts() {
		return productDAO.lstProduct();
	}

	@Override
	@Transactional
	public Product getProductById(Integer id) {
		return productDAO.getProductById(id);
	}

	@Override
	@Transactional
	public void removeProduct(Integer id) {
		productDAO.removeProduct(id);
	}

}
