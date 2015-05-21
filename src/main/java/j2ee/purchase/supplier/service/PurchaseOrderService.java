package j2ee.purchase.supplier.service;

import java.util.List;

import j2ee.purchase.supplier.model.PurchaseOrder;

public interface PurchaseOrderService {
	public void addPurchaseOrder(PurchaseOrder purchaseOrder);

	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);

	public List<PurchaseOrder> lstPurchaseOrders();

	public PurchaseOrder getPurchaseOrderById(Integer id);

	public void removePurchaseOrder(Integer id);
}
