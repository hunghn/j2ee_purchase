package j2ee.purchase.dao;

import java.util.List;

import j2ee.purchase.model.Currency;

public interface CurrencyDAO {
	public void addCurrency(Currency currency);

	public void updateCurrency(Currency currency);

	public void removeCurrency(Integer id);

	public List<Currency> lstCurrency();

	public Currency getCurrencyById(Integer id);
}
