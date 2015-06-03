package j2ee.purchase.service.impl;

import j2ee.purchase.dao.PurchaseOrderLineDAO;
import j2ee.purchase.model.PurchaseOrderLine;
import j2ee.purchase.service.PurchaseOrderLineService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseOrderLineServiceImpl implements PurchaseOrderLineService {

	@Autowired
	private PurchaseOrderLineDAO purchaseOrderLineDAO;


	@Override
	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		purchaseOrderLineDAO.addPurchaseOrderLine(purchaseOrderLine);

	}

	@Override
	public void updatePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		purchaseOrderLineDAO.updatePurchaseOrderLine(purchaseOrderLine);

	}

	@Override
	public List<PurchaseOrderLine> lstPurchaseOrderLines() {
		return purchaseOrderLineDAO.lstPurchaseOrderLine();
	}

	@Override
	public PurchaseOrderLine getPurchaseOrderLineById(String id) {
		return purchaseOrderLineDAO.getPurchaseOrderLineById(id);
	}

	@Override
	public void removePurchaseOrderLine(String id) {
		purchaseOrderLineDAO.removePurchaseOrderLine(id);
	}

}
