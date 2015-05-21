package j2ee.purchase.supplier.service.impl;

import j2ee.purchase.supplier.dao.AccountTaxDAO;
import j2ee.purchase.supplier.model.AccountTax;
import j2ee.purchase.supplier.service.AccountTaxService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountTaxServiceImpl implements AccountTaxService {

	private AccountTaxDAO accountTaxDAO;

	public void setAccountTaxDAO(AccountTaxDAO accountTaxDAO) {
		this.accountTaxDAO = accountTaxDAO;
	}

	@Override
	@Transactional
	public void addAccountTax(AccountTax accountTax) {
		accountTaxDAO.addAccountTax(accountTax);

	}

	@Override
	@Transactional
	public void updateAccountTax(AccountTax accountTax) {
		accountTaxDAO.updateAccountTax(accountTax);

	}

	@Override
	@Transactional
	public List<AccountTax> lstAccountTaxs() {
		return accountTaxDAO.lstAccountTax();
	}

	@Override
	@Transactional
	public AccountTax getAccountTaxById(Integer id) {
		return accountTaxDAO.getAccountTaxById(id);
	}

	@Override
	@Transactional
	public void removeAccountTax(Integer id) {
		accountTaxDAO.removeAccountTax(id);
	}

}
