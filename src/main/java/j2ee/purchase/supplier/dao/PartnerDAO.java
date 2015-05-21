package j2ee.purchase.supplier.dao;

import java.util.List;

import j2ee.purchase.supplier.model.Partner;

public interface PartnerDAO {
	public void addPartner(Partner partner);

	public void updatePartner(Partner partner);

	public void removePartner(Integer id);

	public List<Partner> lstPartner();

	public Partner getPartnerById(Integer id);
}
