package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.AccountTaxDAO;
import j2ee.purchase.model.AccountTax;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountTaxDAOImpl implements AccountTaxDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AccountTaxDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addAccountTax(AccountTax accountTax) {
		Session session = this.getCurrentSession();
		session.persist(accountTax);
		logger.info("AccountTax saved successfully, AccountTax Details="
				+ accountTax);

	}

	@Override
	public void updateAccountTax(AccountTax accountTax) {
		Session session = this.getCurrentSession();
		session.update(accountTax);
		logger.info("AccountTax updated successfully, AccountTax Details="
				+ accountTax);
	}

	@Override
	public void removeAccountTax(String id) {
		Session session = this.getCurrentSession();
		AccountTax accountTax = (AccountTax) session.get(AccountTax.class, id);
		if (null != accountTax) {
			session.delete(accountTax);
		}
		logger.info("AccountTax deleted successfully, AccountTax details="
				+ accountTax);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountTax> lstAccountTax() {
		Session session = this.getCurrentSession();
		List<AccountTax> lstAccountTax = session.createQuery("from AccountTax")
				.list();
		return lstAccountTax;
	}

	@Override
	public AccountTax getAccountTaxById(String id) {
		Session session = this.getCurrentSession();
		AccountTax accountTax = (AccountTax) session.get(AccountTax.class, id);
		return accountTax;
	}

	@Override
	public AccountTax getAccountTaxByName(String name) {
		Session session = this.getCurrentSession();
		String hql = "from AccountTax as o where o.name=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<AccountTax> lstAccountTax = query.list();
		if (!lstAccountTax.isEmpty()) {
			return lstAccountTax.get(0);
		}
		return null;
	}

}
