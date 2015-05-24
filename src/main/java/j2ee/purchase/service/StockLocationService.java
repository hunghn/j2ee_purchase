package j2ee.purchase.supplier.service;

import java.util.List;

import j2ee.purchase.supplier.model.StockLocation;

public interface StockLocationService {
	public void addStockLocation(StockLocation stockLocation);

	public void updateStockLocation(StockLocation stockLocation);

	public List<StockLocation> lstStockLocations();

	public StockLocation getStockLocationById(Integer id);

	public void removeStockLocation(Integer id);
}
