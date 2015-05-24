package j2ee.purchase.supplier.dao;

import java.util.List;

import j2ee.purchase.supplier.model.Company;

public interface CompanyDAO {
	public void addCompany(Company company);

	public void updateCompany(Company company);

	public void removeCompany(Integer id);

	public List<Company> lstCompany();

	public Company getCompanyById(Integer id);
}
