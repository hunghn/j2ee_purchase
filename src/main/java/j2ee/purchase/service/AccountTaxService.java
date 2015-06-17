package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.AccountTax;

public interface AccountTaxService {
	public void addAccountTax(AccountTax accountTax);

	public void updateAccountTax(AccountTax accountTax);

	public List<AccountTax> lstAccountTaxs();

	public AccountTax getAccountTaxById(String id);

	public void removeAccountTax(String id);
	
	public boolean checkExistAccountTax(String name);
}
