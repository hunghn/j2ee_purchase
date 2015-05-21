package j2ee.purchase.supplier.dao;

import java.util.List;

import j2ee.purchase.supplier.model.AccountTax;

public interface AccountTaxDAO {
	public void addAccountTax(AccountTax accountTax);

	public void updateAccountTax(AccountTax accountTax);

	public void removeAccountTax(Integer id);

	public List<AccountTax> lstAccountTax();

	public AccountTax getAccountTaxById(Integer id);
}
