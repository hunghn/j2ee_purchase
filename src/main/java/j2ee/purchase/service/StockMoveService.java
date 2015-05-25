package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.StockMove;

public interface StockMoveService {
	public void addStockMove(StockMove stockMove);

	public void updateStockMove(StockMove stockMove);

	public List<StockMove> lstStockMoves();

	public StockMove getStockMoveById(Integer id);

	public void removeStockMove(Integer id);
}
