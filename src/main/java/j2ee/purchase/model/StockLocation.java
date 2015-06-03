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
@Table(name = "STOCKLOCATION")
public class StockLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -764621533025955792L;

	@Id
	@Column(name = "stock_location_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private String name;
	private Boolean active;
	private String note;

	@JsonBackReference
	@OneToMany(mappedBy = "stock_location")
	private Set<PurchaseOrder> purchase_orders;

	public String getId() {
		return id;
	}

	public void setId(String stock_location_id) {
		this.id = stock_location_id;
	}

	public String getLocation_name() {
		return name;
	}

	public void setLocation_name(String location_name) {
		this.name = location_name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name;

	}

}
