package j2ee.purchase.service.impl;

import j2ee.purchase.dao.StockLocationDAO;
import j2ee.purchase.model.StockLocation;
import j2ee.purchase.service.StockLocationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StockLocationServiceImpl implements StockLocationService {

	@Autowired
	private StockLocationDAO stockLocationDAO;

	@Override
	public void addStockLocation(StockLocation stockLocation) {
		stockLocationDAO.addStockLocation(stockLocation);

	}

	@Override
	public void updateStockLocation(StockLocation stockLocation) {
		stockLocationDAO.updateStockLocation(stockLocation);

	}

	@Override
	public List<StockLocation> lstStockLocations() {
		return stockLocationDAO.lstStockLocation();
	}

	@Override
	public StockLocation getStockLocationById(String id) {
		return stockLocationDAO.getStockLocationById(id);
	}

	@Override
	public void removeStockLocation(String id) {
		stockLocationDAO.removeStockLocation(id);
	}

}
