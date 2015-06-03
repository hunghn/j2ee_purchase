package j2ee.purchase.service.impl;

import j2ee.purchase.dao.CurrencyDAO;
import j2ee.purchase.model.Currency;
import j2ee.purchase.service.CurrencyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDAO currencyDAO;

	@Override
	@Transactional
	public void addCurrency(Currency currency) {
		currencyDAO.addCurrency(currency);

	}

	@Override
	@Transactional
	public void updateCurrency(Currency currency) {
		currencyDAO.updateCurrency(currency);

	}

	@Override
	@Transactional
	public List<Currency> lstCurrencys() {
		return currencyDAO.lstCurrency();
	}

	@Override
	@Transactional
	public Currency getCurrencyById(String id) {
		return currencyDAO.getCurrencyById(id);
	}

	@Override
	@Transactional
	public void removeCurrency(String id) {
		currencyDAO.removeCurrency(id);
	}

}
