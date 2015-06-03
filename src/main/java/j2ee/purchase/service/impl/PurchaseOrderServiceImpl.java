package j2ee.purchase.service.impl;

import j2ee.purchase.dao.PurchaseOrderDAO;
import j2ee.purchase.model.PurchaseOrder;
import j2ee.purchase.service.PurchaseOrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderDAO purchaseOrderDAO;

	@Override
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderDAO.addPurchaseOrder(purchaseOrder);

	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderDAO.updatePurchaseOrder(purchaseOrder);

	}

	@Override
	public List<PurchaseOrder> lstPurchaseOrders() {
		return purchaseOrderDAO.lstPurchaseOrder();
	}

	@Override
	public PurchaseOrder getPurchaseOrderById(String id) {
		return purchaseOrderDAO.getPurchaseOrderById(id);
	}

	@Override
	public void removePurchaseOrder(String id) {
		purchaseOrderDAO.removePurchaseOrder(id);
	}

}
