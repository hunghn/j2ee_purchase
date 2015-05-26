package j2ee.purchase.impl;

import j2ee.purchase.dao.StockMoveDAO;
import j2ee.purchase.model.StockMove;
import j2ee.purchase.service.StockMoveService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockMoveServiceImpl implements StockMoveService {

	private StockMoveDAO stockMoveDAO;

	public void setStockMoveDAO(StockMoveDAO stockMoveDAO) {
		this.stockMoveDAO = stockMoveDAO;
	}

	@Override
	@Transactional
	public void addStockMove(StockMove stockMove) {
		stockMoveDAO.addStockMove(stockMove);

	}

	@Override
	@Transactional
	public void updateStockMove(StockMove stockMove) {
		stockMoveDAO.updateStockMove(stockMove);

	}

	@Override
	@Transactional
	public List<StockMove> lstStockMoves() {
		return stockMoveDAO.lstStockMove();
	}

	@Override
	@Transactional
	public StockMove getStockMoveById(Integer id) {
		return stockMoveDAO.getStockMoveById(id);
	}

	@Override
	@Transactional
	public void removeStockMove(Integer id) {
		stockMoveDAO.removeStockMove(id);
	}

}
