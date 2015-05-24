package j2ee.purchase.supplier.service;

import java.util.List;

import j2ee.purchase.supplier.model.Currency;

public interface CurrencyService {
	public void addCurrency(Currency currency);

	public void updateCurrency(Currency currency);

	public List<Currency> lstCurrencys();

	public Currency getCurrencyById(Integer id);

	public void removeCurrency(Integer id);
}
