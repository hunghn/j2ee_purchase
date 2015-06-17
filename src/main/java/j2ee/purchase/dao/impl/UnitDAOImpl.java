package j2ee.purchase.dao.impl;

import j2ee.purchase.dao.UnitDAO;
import j2ee.purchase.model.Unit;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UnitDAOImpl implements UnitDAO{

	private static final Logger logger = LoggerFactory
			.getLogger(UnitDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addUnit(Unit unit) {
		Session session = this.getCurrentSession();
		session.persist(unit);
		logger.info("Unit saved successfully, Unit Details="
				+ unit);

	}

	@Override
	public void updateUnit(Unit unit) {
		Session session = this.getCurrentSession();
		session.update(unit);
		logger.info("Unit updated successfully, Unit Details="
				+ unit);
	}

	@Override
	public void removeUnit(String id) {
		Session session = this.getCurrentSession();
		Unit unit = (Unit) session.get(Unit.class, id);
		if (null != unit) {
			session.delete(unit);
		}
		logger.info("Unit deleted successfully, Unit details="
				+ unit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unit> lstUnit() {
		Session session = this.getCurrentSession();
		List<Unit> lstUnit = session.createQuery("from Unit").list();
		return lstUnit;
	}

	@Override
	public Unit getUnitById(String id) {
		Session session = this.getCurrentSession();
		Unit unit = (Unit) session.get(Unit.class, id);
		return unit;
	}

	@Override
	public Unit getUnitByName(String name) {
		Session session = this.getCurrentSession();
		String hql = "from Unit as o where o.name=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Unit> lstUnit = query.list();
		if (!lstUnit.isEmpty()) {
			return lstUnit.get(0);
		}
		return null;
	}

}
