package j2ee.purchase.supplier.dao;

import java.util.List;

import j2ee.purchase.supplier.model.PurchaseOrderLine;

public interface PurchaseOrderLineDAO {
	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine);

	public void updatePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine);

	public void removePurchaseOrderLine(Integer id);

	public List<PurchaseOrderLine> lstPurchaseOrderLine();

	public PurchaseOrderLine getPurchaseOrderLineById(Integer id);
}