package j2ee.purchase.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CURRENCY")
public class Currency  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 663092449397894857L;

	@Id
	@Column(name = "currency_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private String name;

	@OneToMany(mappedBy = "currency")
	@JsonBackReference
	private Set<PurchaseOrder> purchase_orders;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
