package j2ee.purchase.supplier.dao.impl;

import j2ee.purchase.supplier.dao.PartnerDAO;
import j2ee.purchase.supplier.model.Partner;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerDAOImpl implements PartnerDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PartnerDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPartner(Partner partner) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(partner);
		logger.info("Partner saved successfully, Partner Details=" + partner);

	}

	@Override
	public void updatePartner(Partner partner) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(partner);
		logger.info("Partner updated successfully, Partner Details=" + partner);
	}

	@Override
	public void removePartner(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Partner partner = (Partner) session.load(Partner.class, new Integer(id));
		if (null != partner) {
			session.delete(partner);
		}
		logger.info("Partner deleted successfully, Partner details=" + partner);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partner> lstPartner() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Partner> lstPartner = session.createQuery("from Partner").list();
		return lstPartner;
	}

	@Override
	public Partner getPartnerById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Partner partner = (Partner) session.load(Partner.class, new Integer(id));
		return partner;
	}

}
