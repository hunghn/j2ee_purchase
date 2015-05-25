package j2ee.purchase.dao;

import java.util.List;

import j2ee.purchase.model.PurchaseOrder;

public interface PurchaseOrderDAO {
	public void addPurchaseOrder(PurchaseOrder purchaseOrder);

	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);

	public void removePurchaseOrder(Integer id);

	public List<PurchaseOrder> lstPurchaseOrder();

	public PurchaseOrder getPurchaseOrderById(Integer id);
}
