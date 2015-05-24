package j2ee.purchase.supplier.service;

import java.util.List;

import j2ee.purchase.supplier.model.Product;

public interface ProductService {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public List<Product> lstProducts();

	public Product getProductById(Integer id);

	public void removeProduct(Integer id);
}
