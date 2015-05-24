package j2ee.purchase.supplier.service.impl;

import j2ee.purchase.supplier.dao.PurchaseOrderLineDAO;
import j2ee.purchase.supplier.model.PurchaseOrderLine;
import j2ee.purchase.supplier.service.PurchaseOrderLineService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseOrderLineServiceImpl implements PurchaseOrderLineService {

	private PurchaseOrderLineDAO purchaseOrderLineDAO;

	public void setPurchaseOrderLineDAO(PurchaseOrderLineDAO purchaseOrderLineDAO) {
		this.purchaseOrderLineDAO = purchaseOrderLineDAO;
	}

	@Override
	@Transactional
	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		purchaseOrderLineDAO.addPurchaseOrderLine(purchaseOrderLine);

	}

	@Override
	@Transactional
	public void updatePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		purchaseOrderLineDAO.updatePurchaseOrderLine(purchaseOrderLine);

	}

	@Override
	@Transactional
	public List<PurchaseOrderLine> lstPurchaseOrderLines() {
		return purchaseOrderLineDAO.lstPurchaseOrderLine();
	}

	@Override
	@Transactional
	public PurchaseOrderLine getPurchaseOrderLineById(Integer id) {
		return purchaseOrderLineDAO.getPurchaseOrderLineById(id);
	}

	@Override
	@Transactional
	public void removePurchaseOrderLine(Integer id) {
		purchaseOrderLineDAO.removePurchaseOrderLine(id);
	}

}
