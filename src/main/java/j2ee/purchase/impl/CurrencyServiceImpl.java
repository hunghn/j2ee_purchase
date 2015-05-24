package j2ee.purchase.supplier.service.impl;

import j2ee.purchase.supplier.dao.CurrencyDAO;
import j2ee.purchase.supplier.model.Currency;
import j2ee.purchase.supplier.service.CurrencyService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	private CurrencyDAO currencyDAO;

	public void setCurrencyDAO(CurrencyDAO currencyDAO) {
		this.currencyDAO = currencyDAO;
	}

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
	public Currency getCurrencyById(Integer id) {
		return currencyDAO.getCurrencyById(id);
	}

	@Override
	@Transactional
	public void removeCurrency(Integer id) {
		currencyDAO.removeCurrency(id);
	}

}
