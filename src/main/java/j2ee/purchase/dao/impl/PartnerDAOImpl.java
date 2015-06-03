package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.PartnerDAO;
import j2ee.purchase.model.Partner;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerDAOImpl implements PartnerDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PartnerDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPartner(Partner partner) {
		Session session = this.getCurrentSession();
		session.persist(partner);
		logger.info("Partner saved successfully, Partner Details=" + partner);

	}

	@Override
	public void updatePartner(Partner partner) {
		Session session = this.getCurrentSession();
		session.update(partner);
		logger.info("Partner updated successfully, Partner Details=" + partner);
	}

	@Override
	public void removePartner(String id) {
		Session session = this.getCurrentSession();
		Partner partner = (Partner) session
				.get(Partner.class, new String(id));
		if (null != partner) {
			session.delete(partner);
		}
		logger.info("Partner deleted successfully, Partner details=" + partner);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partner> lstPartner() {
		Session session = this.getCurrentSession();
		List<Partner> lstPartner = session.createQuery("from Partner").list();
		return lstPartner;
	}

	@Override
	public Partner getPartnerById(String id) {
		Session session = this.getCurrentSession();
		Partner partner = (Partner) session
				.get(Partner.class, new String(id));
		return partner;
	}

}
