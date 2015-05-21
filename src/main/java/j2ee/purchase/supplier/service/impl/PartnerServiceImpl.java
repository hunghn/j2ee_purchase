package j2ee.purchase.supplier.service.impl;

import j2ee.purchase.supplier.dao.PartnerDAO;
import j2ee.purchase.supplier.model.Partner;
import j2ee.purchase.supplier.service.PartnerService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PartnerServiceImpl implements PartnerService {

	private PartnerDAO partnerDAO;

	public void setPartnerDAO(PartnerDAO partnerDAO) {
		this.partnerDAO = partnerDAO;
	}

	@Override
	@Transactional
	public void addPartner(Partner partner) {
		partnerDAO.addPartner(partner);

	}

	@Override
	@Transactional
	public void updatePartner(Partner partner) {
		partnerDAO.updatePartner(partner);

	}

	@Override
	@Transactional
	public List<Partner> lstPartners() {
		return partnerDAO.lstPartner();
	}

	@Override
	@Transactional
	public Partner getPartnerById(Integer id) {
		return partnerDAO.getPartnerById(id);
	}

	@Override
	@Transactional
	public void removePartner(Integer id) {
		partnerDAO.removePartner(id);
	}

}
