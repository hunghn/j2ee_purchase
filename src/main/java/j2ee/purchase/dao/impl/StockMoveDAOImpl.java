package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.StockMoveDAO;
import j2ee.purchase.model.StockMove;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StockMoveDAOImpl implements StockMoveDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(StockMoveDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStockMove(StockMove stockMove) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(stockMove);
		logger.info("StockMove saved successfully, StockMove Details=" + stockMove);

	}

	@Override
	public void updateStockMove(StockMove stockMove) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(stockMove);
		logger.info("StockMove updated successfully, StockMove Details=" + stockMove);
	}

	@Override
	public void removeStockMove(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		StockMove stockMove = (StockMove) session
				.load(StockMove.class, new Integer(id));
		if (null != stockMove) {
			session.delete(stockMove);
		}
		logger.info("StockMove deleted successfully, StockMove details=" + stockMove);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockMove> lstStockMove() {
		Session session = this.sessionFactory.getCurrentSession();
		List<StockMove> lstStockMove = session.createQuery("from StockMove").list();
		return lstStockMove;
	}

	@Override
	public StockMove getStockMoveById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		StockMove stockMove = (StockMove) session
				.load(StockMove.class, new Integer(id));
		return stockMove;
	}

}
