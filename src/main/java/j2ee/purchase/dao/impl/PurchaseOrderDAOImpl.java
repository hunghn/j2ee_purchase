package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.PurchaseOrderDAO;
import j2ee.purchase.model.PurchaseOrder;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PurchaseOrderDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
		Session session = this.getCurrentSession();
		session.persist(purchaseOrder);
		logger.info("PurchaseOrder saved successfully, PurchaseOrder Details=" + purchaseOrder);

	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		Session session = this.getCurrentSession();
		session.update(purchaseOrder);
		logger.info("PurchaseOrder updated successfully, PurchaseOrder Details=" + purchaseOrder);
	}

	@Override
	public void removePurchaseOrder(String id) {
		Session session = this.getCurrentSession();
		PurchaseOrder purchaseOrder = (PurchaseOrder) session
				.get(PurchaseOrder.class, id);
		if (null != purchaseOrder) {
			session.delete(purchaseOrder);
		}
		logger.info("PurchaseOrder deleted successfully, PurchaseOrder details=" + purchaseOrder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseOrder> lstPurchaseOrder() {
		Session session = this.getCurrentSession();
		List<PurchaseOrder> lstPurchaseOrder = session.createQuery("from PurchaseOrder").list();
		return lstPurchaseOrder;
	}

	@Override
	public PurchaseOrder getPurchaseOrderById(String id) {
		Session session = this.getCurrentSession();
		PurchaseOrder purchaseOrder = (PurchaseOrder) session
				.get(PurchaseOrder.class, id);
		return purchaseOrder;
	}

}
