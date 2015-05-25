package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.ProductDAO;
import j2ee.purchase.model.Product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		logger.info("Product saved successfully, Product Details=" + product);

	}

	@Override
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		logger.info("Product updated successfully, Product Details=" + product);
	}

	@Override
	public void removeProduct(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session
				.load(Product.class, new Integer(id));
		if (null != product) {
			session.delete(product);
		}
		logger.info("Product deleted successfully, Product details=" + product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> lstProduct() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> lstProduct = session.createQuery("from Product").list();
		return lstProduct;
	}

	@Override
	public Product getProductById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session
				.load(Product.class, new Integer(id));
		return product;
	}

}
