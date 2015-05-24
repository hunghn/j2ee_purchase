package j2ee.purchase.supplier.dao;

import java.util.List;

import j2ee.purchase.supplier.model.StockLocation;

public interface StockLocationDAO {
	public void addStockLocation(StockLocation stockLocation);

	public void updateStockLocation(StockLocation stockLocation);

	public void removeStockLocation(Integer id);

	public List<StockLocation> lstStockLocation();

	public StockLocation getStockLocationById(Integer id);
}
