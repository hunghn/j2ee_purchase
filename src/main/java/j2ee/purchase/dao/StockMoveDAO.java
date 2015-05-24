package j2ee.purchase.supplier.dao;

import java.util.List;

import j2ee.purchase.supplier.model.StockMove;

public interface StockMoveDAO {
	public void addStockMove(StockMove stockMove);

	public void updateStockMove(StockMove stockMove);

	public void removeStockMove(Integer id);

	public List<StockMove> lstStockMove();

	public StockMove getStockMoveById(Integer id);
}
