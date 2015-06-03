package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.PurchaseOrder;

public interface PurchaseOrderService {
	public void addPurchaseOrder(PurchaseOrder purchaseOrder);

	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);

	public List<PurchaseOrder> lstPurchaseOrders();

	public PurchaseOrder getPurchaseOrderById(String id);

	public void removePurchaseOrder(String id);
}
