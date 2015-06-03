package j2ee.purchase.dao;

import java.util.List;

import j2ee.purchase.model.AccountTax;

public interface AccountTaxDAO {
	public void addAccountTax(AccountTax accountTax);

	public void updateAccountTax(AccountTax accountTax);

	public void removeAccountTax(String id);

	public List<AccountTax> lstAccountTax();

	public AccountTax getAccountTaxById(String id);
}
