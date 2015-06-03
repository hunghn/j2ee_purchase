package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.PurchaseOrderLine;

public interface PurchaseOrderLineService {
	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine);

	public void updatePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine);

	public List<PurchaseOrderLine> lstPurchaseOrderLines();

	public PurchaseOrderLine getPurchaseOrderLineById(String id);

	public void removePurchaseOrderLine(String id);
}
