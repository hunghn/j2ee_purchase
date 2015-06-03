package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.StockLocationDAO;
import j2ee.purchase.model.StockLocation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StockLocationDAOImpl implements StockLocationDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(StockLocationDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addStockLocation(StockLocation stockLocation) {
		Session session = this.getCurrentSession();
		session.persist(stockLocation);
		logger.info("StockLocation saved successfully, StockLocation Details="
				+ stockLocation);

	}

	@Override
	public void updateStockLocation(StockLocation stockLocation) {
		Session session = this.getCurrentSession();
		session.update(stockLocation);
		logger.info("StockLocation updated successfully, StockLocation Details="
				+ stockLocation);
	}

	@Override
	public void removeStockLocation(String id) {
		Session session = this.getCurrentSession();
		StockLocation stockLocation = (StockLocation) session.get(
				StockLocation.class, id);
		if (null != stockLocation) {
			session.delete(stockLocation);
		}
		logger.info("StockLocation deleted successfully, StockLocation details="
				+ stockLocation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockLocation> lstStockLocation() {
		Session session = this.getCurrentSession();
		List<StockLocation> lstStockLocation = session.createQuery(
				"from StockLocation").list();
		return lstStockLocation;
	}

	@Override
	public StockLocation getStockLocationById(String id) {
		Session session = this.getCurrentSession();
		StockLocation stockLocation = (StockLocation) session.get(
				StockLocation.class, id);
		return stockLocation;
	}

}
