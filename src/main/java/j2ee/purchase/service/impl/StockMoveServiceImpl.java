package j2ee.purchase.service.impl;

import j2ee.purchase.dao.StockMoveDAO;
import j2ee.purchase.model.StockMove;
import j2ee.purchase.service.StockMoveService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StockMoveServiceImpl implements StockMoveService {

	@Autowired
	private StockMoveDAO stockMoveDAO;
	
	@Override
	public void addStockMove(StockMove stockMove) {
		stockMoveDAO.addStockMove(stockMove);

	}

	@Override
	public void updateStockMove(StockMove stockMove) {
		stockMoveDAO.updateStockMove(stockMove);

	}

	@Override
	public List<StockMove> lstStockMoves() {
		return stockMoveDAO.lstStockMove();
	}

	@Override
	public StockMove getStockMoveById(String id) {
		return stockMoveDAO.getStockMoveById(id);
	}

	@Override
	public void removeStockMove(String id) {
		stockMoveDAO.removeStockMove(id);
	}

}
