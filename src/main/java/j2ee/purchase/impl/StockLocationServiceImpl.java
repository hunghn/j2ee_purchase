package j2ee.purchase.impl;

import j2ee.purchase.dao.StockLocationDAO;
import j2ee.purchase.model.StockLocation;
import j2ee.purchase.service.StockLocationService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockLocationServiceImpl implements StockLocationService {

	private StockLocationDAO stockLocationDAO;

	public void setStockLocationDAO(StockLocationDAO stockLocationDAO) {
		this.stockLocationDAO = stockLocationDAO;
	}

	@Override
	@Transactional
	public void addStockLocation(StockLocation stockLocation) {
		stockLocationDAO.addStockLocation(stockLocation);

	}

	@Override
	@Transactional
	public void updateStockLocation(StockLocation stockLocation) {
		stockLocationDAO.updateStockLocation(stockLocation);

	}

	@Override
	@Transactional
	public List<StockLocation> lstStockLocations() {
		return stockLocationDAO.lstStockLocation();
	}

	@Override
	@Transactional
	public StockLocation getStockLocationById(Integer id) {
		return stockLocationDAO.getStockLocationById(id);
	}

	@Override
	@Transactional
	public void removeStockLocation(Integer id) {
		stockLocationDAO.removeStockLocation(id);
	}

}
