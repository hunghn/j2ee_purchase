package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.ProductDAO;
import j2ee.purchase.model.Product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addProduct(Product product) {
		Session session = this.getCurrentSession();
		session.persist(product);
		logger.info("Product saved successfully, Product Details=" + product);

	}

	@Override
	public void updateProduct(Product product) {
		Session session = this.getCurrentSession();
		session.update(product);
		logger.info("Product updated successfully, Product Details=" + product);
	}

	@Override
	public void removeProduct(String id) {
		Session session = this.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		if (null != product) {
			session.delete(product);
		}
		logger.info("Product deleted successfully, Product details=" + product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> lstProduct() {
		Session session = this.getCurrentSession();
		List<Product> lstProduct = session.createQuery("from Product").list();
		return lstProduct;
	}

	@Override
	public Product getProductById(String id) {
		Session session = this.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		return product;
	}

}
