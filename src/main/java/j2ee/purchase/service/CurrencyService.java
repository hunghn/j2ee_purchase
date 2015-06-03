package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.Currency;

public interface CurrencyService {
	public void addCurrency(Currency currency);

	public void updateCurrency(Currency currency);

	public List<Currency> lstCurrencys();

	public Currency getCurrencyById(String id);

	public void removeCurrency(String id);
}
