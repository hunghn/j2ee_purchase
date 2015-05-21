package j2ee.purchase.supplier.service.impl;

import j2ee.purchase.supplier.dao.CompanyDAO;
import j2ee.purchase.supplier.model.Company;
import j2ee.purchase.supplier.service.CompanyService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyDAO companyDAO;

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	@Override
	@Transactional
	public void addCompany(Company comapny) {
		companyDAO.addCompany(comapny);

	}

	@Override
	@Transactional
	public void updateCompany(Company company) {
		companyDAO.updateCompany(company);

	}

	@Override
	@Transactional
	public List<Company> lstCompanys() {
		return companyDAO.lstCompany();
	}

	@Override
	@Transactional
	public Company getCompanyById(Integer id) {
		return companyDAO.getCompanyById(id);
	}

	@Override
	@Transactional
	public void removeCompany(Integer id) {
		companyDAO.removeCompany(id);
	}

}
