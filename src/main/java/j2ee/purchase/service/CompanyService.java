package j2ee.purchase.supplier.service;

import java.util.List;

import j2ee.purchase.supplier.model.Company;

public interface CompanyService {
	public void addCompany(Company company);

	public void updateCompany(Company company);

	public List<Company> lstCompanys();

	public Company getCompanyById(Integer id);

	public void removeCompany(Integer id);
}
