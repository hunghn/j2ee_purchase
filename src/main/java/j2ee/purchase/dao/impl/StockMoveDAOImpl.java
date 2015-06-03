package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.StockMoveDAO;
import j2ee.purchase.model.StockMove;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StockMoveDAOImpl implements StockMoveDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(StockMoveDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addStockMove(StockMove stockMove) {
		Session session = this.getCurrentSession();
		session.persist(stockMove);
		logger.info("StockMove saved successfully, StockMove Details="
				+ stockMove);

	}

	@Override
	public void updateStockMove(StockMove stockMove) {
		Session session = this.getCurrentSession();
		session.update(stockMove);
		logger.info("StockMove updated successfully, StockMove Details="
				+ stockMove);
	}

	@Override
	public void removeStockMove(String id) {
		Session session = this.getCurrentSession();
		StockMove stockMove = (StockMove) session.get(StockMove.class,
				id);
		if (null != stockMove) {
			session.delete(stockMove);
		}
		logger.info("StockMove deleted successfully, StockMove details="
				+ stockMove);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockMove> lstStockMove() {
		Session session = this.getCurrentSession();
		List<StockMove> lstStockMove = session.createQuery("from StockMove")
				.list();
		return lstStockMove;
	}

	@Override
	public StockMove getStockMoveById(String id) {
		Session session = this.getCurrentSession();
		StockMove stockMove = (StockMove) session.get(StockMove.class,
				id);
		return stockMove;
	}

}
