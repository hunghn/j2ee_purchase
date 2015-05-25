package j2ee.purchase.service;

import java.util.List;

import j2ee.purchase.model.Partner;

public interface PartnerService {
	public void addPartner(Partner partner);

	public void updatePartner(Partner partner);

	public List<Partner> lstPartners();

	public Partner getPartnerById(Integer id);

	public void removePartner(Integer id);
}
