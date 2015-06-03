package j2ee.purchase.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ACCOUNTTAX")
public class AccountTax implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6143224711195016654L;

	@Id
	@Column(name = "account_tax_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private String name;
	private Boolean active;
	private Float amount;
	private Double price_include;
	private String description;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "accounttaxs")
	private Set<PurchaseOrderLine> purchaseorderlines;

	public Set<PurchaseOrderLine> getPurchaseorderlines() {
		return purchaseorderlines;
	}

	public void setPurchaseorderlines(Set<PurchaseOrderLine> purchaseorderlines) {
		this.purchaseorderlines = purchaseorderlines;
	}

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
