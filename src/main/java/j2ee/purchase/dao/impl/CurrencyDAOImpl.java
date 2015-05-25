package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.CurrencyDAO;
import j2ee.purchase.model.Currency;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyDAOImpl implements CurrencyDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(CurrencyDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCurrency(Currency currency) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(currency);
		logger.info("Currency saved successfully, Currency Details=" + currency);

	}

	@Override
	public void updateCurrency(Currency currency) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(currency);
		logger.info("Currency updated successfully, Currency Details=" + currency);
	}

	@Override
	public void removeCurrency(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Currency currency = (Currency) session
				.load(Currency.class, new Integer(id));
		if (null != currency) {
			session.delete(currency);
		}
		logger.info("Currency deleted successfully, Currency details=" + currency);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> lstCurrency() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Currency> lstCurrency = session.createQuery("from Currency").list();
		return lstCurrency;
	}

	@Override
	public Currency getCurrencyById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		Currency currency = (Currency) session
				.load(Currency.class, new Integer(id));
		return currency;
	}

}
