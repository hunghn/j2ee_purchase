package j2ee.purchase.supplier.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STOCKLOCATION")
public class StockLocation {

	@Id
	@Column(name = "stock_location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private Boolean active;
	private String note;
	
	@OneToMany(mappedBy = "stock_location")
	private Set<PurchaseOrder> purchase_orders;

	public Integer getStock_location_id() {
		return id;
	}

	public void setStock_location_id(Integer stock_location_id) {
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

}
