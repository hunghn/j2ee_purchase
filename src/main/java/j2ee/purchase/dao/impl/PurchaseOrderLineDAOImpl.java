package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.PurchaseOrderLineDAO;
import j2ee.purchase.model.PurchaseOrderLine;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderLineDAOImpl implements PurchaseOrderLineDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PurchaseOrderLineDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(purchaseOrderLine);
		logger.info("PurchaseOrderLine saved successfully, PurchaseOrderLine Details=" + purchaseOrderLine);

	}

	@Override
	public void updatePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(purchaseOrderLine);
		logger.info("PurchaseOrderLine updated successfully, PurchaseOrderLine Details=" + purchaseOrderLine);
	}

	@Override
	public void removePurchaseOrderLine(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		PurchaseOrderLine purchaseOrderLine = (PurchaseOrderLine) session
				.load(PurchaseOrderLine.class, new Integer(id));
		if (null != purchaseOrderLine) {
			session.delete(purchaseOrderLine);
		}
		logger.info("PurchaseOrderLine deleted successfully, PurchaseOrderLine details=" + purchaseOrderLine);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseOrderLine> lstPurchaseOrderLine() {
		Session session = this.sessionFactory.getCurrentSession();
		List<PurchaseOrderLine> lstPurchaseOrderLine = session.createQuery("from PurchaseOrderLine").list();
		return lstPurchaseOrderLine;
	}

	@Override
	public PurchaseOrderLine getPurchaseOrderLineById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		PurchaseOrderLine purchaseOrderLine = (PurchaseOrderLine) session
				.load(PurchaseOrderLine.class, new Integer(id));
		return purchaseOrderLine;
	}

}
