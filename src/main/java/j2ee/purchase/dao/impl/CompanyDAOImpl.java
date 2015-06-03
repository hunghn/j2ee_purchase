package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.CompanyDAO;
import j2ee.purchase.model.Company;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(CompanyDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCompany(Company company) {
		Session session = this.getCurrentSession();
		session.persist(company);
		logger.info("Company saved successfully, Company Details=" + company);

	}

	@Override
	public void updateCompany(Company company) {
		Session session = this.getCurrentSession();
		session.update(company);
		logger.info("Company updated successfully, Company Details=" + company);
	}

	@Override
	public void removeCompany(String id) {
		Session session = this.getCurrentSession();
		Company company = (Company) session.get(Company.class, id);
		if (null != company) {
			session.delete(company);
		}
		logger.info("Company deleted successfully, Company details=" + company);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> lstCompany() {
		Session session = this.getCurrentSession();
		List<Company> lstCompany = session.createQuery("from Company").list();
		return lstCompany;
	}

	@Override
	public Company getCompanyById(String id) {
		Session session = this.getCurrentSession();
		Company company = (Company) session.get(Company.class, id);
		return company;
	}

}
