package j2ee.purchase.service;

import j2ee.purchase.model.Unit;

import java.util.List;

public interface UnitService {
	public void addUnit(Unit unit);

	public void updateUnit(Unit unit);

	public List<Unit> lstUnit();

	public Unit getUnitById(String id);

	public void removeUnit(String id);
	
	public boolean checkExistUnit(String name);
}
