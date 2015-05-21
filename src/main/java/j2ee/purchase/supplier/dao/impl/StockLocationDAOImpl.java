package j2ee.purchase.supplier.dao.impl;

import j2ee.purchase.supplier.dao.StockLocationDAO;
import j2ee.purchase.supplier.model.StockLocation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StockLocationDAOImpl implements StockLocationDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(StockLocationDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStockLocation(StockLocation stockLocation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(stockLocation);
		logger.info("StockLocation saved successfully, StockLocation Details=" + stockLocation);

	}

	@Override
	public void updateStockLocation(StockLocation stockLocation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(stockLocation);
		logger.info("StockLocation updated successfully, StockLocation Details=" + stockLocation);
	}

	@Override
	public void removeStockLocation(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		StockLocation stockLocation = (StockLocation) session
				.load(StockLocation.class, new Integer(id));
		if (null != stockLocation) {
			session.delete(stockLocation);
		}
		logger.info("StockLocation deleted successfully, StockLocation details=" + stockLocation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockLocation> lstStockLocation() {
		Session session = this.sessionFactory.getCurrentSession();
		List<StockLocation> lstStockLocation = session.createQuery("from StockLocation").list();
		return lstStockLocation;
	}

	@Override
	public StockLocation getStockLocationById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		StockLocation stockLocation = (StockLocation) session
				.load(StockLocation.class, new Integer(id));
		return stockLocation;
	}

}
