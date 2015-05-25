package j2ee.purchase.dao;

import java.util.List;

import j2ee.purchase.model.Company;

public interface CompanyDAO {
	public void addCompany(Company company);

	public void updateCompany(Company company);

	public void removeCompany(Integer id);

	public List<Company> lstCompany();

	public Company getCompanyById(Integer id);
}
