package j2ee.purchase.service.impl;

import j2ee.purchase.dao.PartnerDAO;
import j2ee.purchase.model.Partner;
import j2ee.purchase.service.PartnerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerDAO partnerDAO;

	@Override
	public void addPartner(Partner partner) {
		partnerDAO.addPartner(partner);

	}

	@Override
	public void updatePartner(Partner partner) {
		partnerDAO.updatePartner(partner);

	}

	@Override
	public List<Partner> lstPartners() {
		return partnerDAO.lstPartner();
	}

	@Override
	public Partner getPartnerById(String id) {
		return partnerDAO.getPartnerById(id);
	}

	@Override
	public void removePartner(String id) {
		partnerDAO.removePartner(id);
	}

}
