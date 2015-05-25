package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.Product;

public interface ProductService {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public List<Product> lstProducts();

	public Product getProductById(Integer id);

	public void removeProduct(Integer id);
}
