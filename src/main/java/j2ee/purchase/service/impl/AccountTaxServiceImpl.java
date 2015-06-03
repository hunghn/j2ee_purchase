package j2ee.purchase.service.impl;

import j2ee.purchase.dao.AccountTaxDAO;
import j2ee.purchase.model.AccountTax;
import j2ee.purchase.service.AccountTaxService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountTaxServiceImpl implements AccountTaxService {

	@Autowired
	private AccountTaxDAO accountTaxDAO;

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
	public AccountTax getAccountTaxById(String id) {
		return accountTaxDAO.getAccountTaxById(id);
	}

	@Override
	@Transactional
	public void removeAccountTax(String id) {
		accountTaxDAO.removeAccountTax(id);
	}

}
