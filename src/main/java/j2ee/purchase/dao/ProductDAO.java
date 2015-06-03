package j2ee.purchase.dao;

import java.util.List;

import j2ee.purchase.model.Product;

public interface ProductDAO {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void removeProduct(String id);

	public List<Product> lstProduct();

	public Product getProductById(String id);
}
