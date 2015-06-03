package j2ee.purchase.service.impl;

import j2ee.purchase.dao.CompanyDAO;
import j2ee.purchase.model.Company;
import j2ee.purchase.service.CompanyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	@Override
	public void addCompany(Company comapny) {
		companyDAO.addCompany(comapny);

	}

	@Override
	public void updateCompany(Company company) {
		companyDAO.updateCompany(company);

	}

	@Override
	public List<Company> lstCompanys() {
		return companyDAO.lstCompany();
	}

	@Override
	public Company getCompanyById(String id) {
		return companyDAO.getCompanyById(id);
	}

	@Override
	public void removeCompany(String id) {
		companyDAO.removeCompany(id);
	}

}
