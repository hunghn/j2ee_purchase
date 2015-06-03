package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.PurchaseOrderLineDAO;
import j2ee.purchase.model.PurchaseOrderLine;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderLineDAOImpl implements PurchaseOrderLineDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PurchaseOrderLineDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		Session session = this.getCurrentSession();
		session.persist(purchaseOrderLine);
		logger.info("PurchaseOrderLine saved successfully, PurchaseOrderLine Details=" + purchaseOrderLine);

	}

	@Override
	public void updatePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		Session session = this.getCurrentSession();
		session.update(purchaseOrderLine);
		logger.info("PurchaseOrderLine updated successfully, PurchaseOrderLine Details=" + purchaseOrderLine);
	}

	@Override
	public void removePurchaseOrderLine(String id) {
		Session session = this.getCurrentSession();
		PurchaseOrderLine purchaseOrderLine = (PurchaseOrderLine) session
				.get(PurchaseOrderLine.class, id);
		if (null != purchaseOrderLine) {
			session.delete(purchaseOrderLine);
		}
		logger.info("PurchaseOrderLine deleted successfully, PurchaseOrderLine details=" + purchaseOrderLine);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseOrderLine> lstPurchaseOrderLine() {
		Session session = this.getCurrentSession();
		List<PurchaseOrderLine> lstPurchaseOrderLine = session.createQuery("from PurchaseOrderLine").list();
		return lstPurchaseOrderLine;
	}

	@Override
	public PurchaseOrderLine getPurchaseOrderLineById(String id) {
		Session session = this.getCurrentSession();
		PurchaseOrderLine purchaseOrderLine = (PurchaseOrderLine) session
				.get(PurchaseOrderLine.class, id);
		return purchaseOrderLine;
	}

}
