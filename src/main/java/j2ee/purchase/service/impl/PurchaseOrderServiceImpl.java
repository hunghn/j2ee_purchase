package j2ee.purchase.impl;

import j2ee.purchase.dao.PurchaseOrderDAO;
import j2ee.purchase.model.PurchaseOrder;
import j2ee.purchase.service.PurchaseOrderService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	private PurchaseOrderDAO purchaseOrderDAO;

	public void setPurchaseOrderDAO(PurchaseOrderDAO purchaseOrderDAO) {
		this.purchaseOrderDAO = purchaseOrderDAO;
	}

	@Override
	@Transactional
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderDAO.addPurchaseOrder(purchaseOrder);

	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderDAO.updatePurchaseOrder(purchaseOrder);

	}

	@Override
	@Transactional
	public List<PurchaseOrder> lstPurchaseOrders() {
		return purchaseOrderDAO.lstPurchaseOrder();
	}

	@Override
	@Transactional
	public PurchaseOrder getPurchaseOrderById(Integer id) {
		return purchaseOrderDAO.getPurchaseOrderById(id);
	}

	@Override
	@Transactional
	public void removePurchaseOrder(Integer id) {
		purchaseOrderDAO.removePurchaseOrder(id);
	}

}
