package j2ee.purchase.dao;

import java.util.List;

import j2ee.purchase.model.StockMove;

public interface StockMoveDAO {
	public void addStockMove(StockMove stockMove);

	public void updateStockMove(StockMove stockMove);

	public void removeStockMove(String id);

	public List<StockMove> lstStockMove();

	public StockMove getStockMoveById(String id);
}
