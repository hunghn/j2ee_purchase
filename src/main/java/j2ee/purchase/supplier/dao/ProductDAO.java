package j2ee.purchase.supplier.dao;

import java.util.List;

import j2ee.purchase.supplier.model.Product;

public interface ProductDAO {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void removeProduct(Integer id);

	public List<Product> lstProduct();

	public Product getProductById(Integer id);
}
