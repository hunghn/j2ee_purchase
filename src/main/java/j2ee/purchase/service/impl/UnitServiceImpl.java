package j2ee.purchase.service.impl;

import j2ee.purchase.dao.UnitDAO;
import j2ee.purchase.model.Unit;
import j2ee.purchase.service.UnitService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitDAO unitDAO;

	@Override
	public void addUnit(Unit unit) {
		unitDAO.addUnit(unit);
	}

	@Override
	public void updateUnit(Unit unit) {
		unitDAO.updateUnit(unit);
	}

	@Override
	public List<Unit> lstUnit() {
		return unitDAO.lstUnit();
	}

	@Override
	public Unit getUnitById(String id) {
		return unitDAO.getUnitById(id);
	}

	@Override
	public void removeUnit(String id) {
		unitDAO.removeUnit(id);
	}

	@Override
	public boolean checkExistUnit(String name) {
		if (unitDAO.getUnitByName(name) != null) {
			return true;
		}
		return false;
	}

}
