package j2ee.purchase.supplier.service;

import java.util.List;

import j2ee.purchase.supplier.model.PurchaseOrderLine;

public interface PurchaseOrderLineService {
	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine);

	public void updatePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine);

	public List<PurchaseOrderLine> lstPurchaseOrderLines();

	public PurchaseOrderLine getPurchaseOrderLineById(Integer id);

	public void removePurchaseOrderLine(Integer id);
}
