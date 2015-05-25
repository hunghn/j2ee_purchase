package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.AccountTaxDAO;
import j2ee.purchase.model.AccountTax;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AccountTaxDAOImpl implements AccountTaxDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AccountTaxDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addAccountTax(AccountTax accountTax) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(accountTax);
		logger.info("AccountTax saved successfully, AccountTax Details=" + accountTax);

	}

	@Override
	public void updateAccountTax(AccountTax accountTax) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(accountTax);
		logger.info("AccountTax updated successfully, AccountTax Details=" + accountTax);
	}

	@Override
	public void removeAccountTax(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		AccountTax accountTax = (AccountTax) session
				.load(AccountTax.class, new Integer(id));
		if (null != accountTax) {
			session.delete(accountTax);
		}
		logger.info("AccountTax deleted successfully, AccountTax details=" + accountTax);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountTax> lstAccountTax() {
		Session session = this.sessionFactory.getCurrentSession();
		List<AccountTax> lstAccountTax = session.createQuery("from AccountTax").list();
		return lstAccountTax;
	}

	@Override
	public AccountTax getAccountTaxById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		AccountTax accountTax = (AccountTax) session
				.load(AccountTax.class, new Integer(id));
		return accountTax;
	}

}
