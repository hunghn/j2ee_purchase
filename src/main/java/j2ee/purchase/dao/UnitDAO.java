package j2ee.purchase.dao;

import j2ee.purchase.model.Unit;

import java.util.List;

public interface UnitDAO {
	public void addUnit(Unit unit);

	public void updateUnit(Unit unit);

	public void removeUnit(String id);

	public List<Unit> lstUnit();

	public Unit getUnitById(String id);

	public Unit getUnitByName(String name);
}
