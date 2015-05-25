package j2ee.purchase.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTTAX")
public class AccountTax {
	@Id
	@Column(name = "account_tax_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private Boolean active;
	private Float amount;
	private Double price_include;
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "accounttaxs")
	private Set<PurchaseOrderLine> purchaseorderlines;

	public Set<PurchaseOrderLine> getPurchaseorderlines() {
		return purchaseorderlines;
	}

	public void setPurchaseorderlines(Set<PurchaseOrderLine> purchaseorderlines) {
		this.purchaseorderlines = purchaseorderlines;
	}

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Double getPrice_include() {
		return price_include;
	}

	public void setPrice_include(Double price_include) {
		this.price_include = price_include;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name;
	}
}
