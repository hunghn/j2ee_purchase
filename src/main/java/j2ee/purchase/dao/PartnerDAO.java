package j2ee.purchase.dao;

import java.util.List;

import j2ee.purchase.model.Partner;

public interface PartnerDAO {
	public void addPartner(Partner partner);

	public void updatePartner(Partner partner);

	public void removePartner(String id);

	public List<Partner> lstPartner();

	public Partner getPartnerById(String id);
}
