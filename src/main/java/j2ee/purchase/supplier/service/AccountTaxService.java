package j2ee.purchase.supplier.service;

import java.util.List;

import j2ee.purchase.supplier.model.AccountTax;

public interface AccountTaxService {
	public void addAccountTax(AccountTax accountTax);

	public void updateAccountTax(AccountTax accountTax);

	public List<AccountTax> lstAccountTaxs();

	public AccountTax getAccountTaxById(Integer id);

	public void removeAccountTax(Integer id);
}
