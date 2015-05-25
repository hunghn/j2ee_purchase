package j2ee.purchase.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class Currency {

	@Id
	@Column(name = "currency_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "currency")
	private Set<PurchaseOrder> purchase_orders;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PurchaseOrder> getPurchase_orders() {
		return purchase_orders;
	}

	public void setPurchase_orders(Set<PurchaseOrder> purchase_orders) {
		this.purchase_orders = purchase_orders;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name;
	}
}
