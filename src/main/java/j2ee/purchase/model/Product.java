package j2ee.purchase.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7906375252681220674L;

	@Id
	@Column(name = "product_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private String name;
	private Date createDate;
	private byte[] image;
	private Boolean active;
	private Double salePrice;
	private Double costPrice;
	private String description;
	private Float warranty;
	private Float customerLeadTime;
	private AccountTax customerTaxes;
	private AccountTax supplierTaxes;
	private String note;

	@JsonBackReference
	@OneToMany(mappedBy = "product")
	private Set<PurchaseOrderLine> purchase_order_lines;

	@JsonBackReference
	@OneToMany(mappedBy = "product")
	private Set<StockMove> stock_moves;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PRODUCT_PARTNER", joinColumns = { @JoinColumn(name = "product_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "partner_id", nullable = false, updatable = false) })
	private Set<Partner> partners;

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

	public Date getCreateDate() {
		return createDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<PurchaseOrderLine> getPurchase_order_lines() {
		return purchase_order_lines;
	}

	public void setPurchase_order_lines(
			Set<PurchaseOrderLine> purchase_order_lines) {
		this.purchase_order_lines = purchase_order_lines;
	}

	public Set<StockMove> getStock_moves() {
		return stock_moves;
	}

	public void setStock_moves(Set<StockMove> stock_moves) {
		this.stock_moves = stock_moves;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getWarranty() {
		return warranty;
	}

	public void setWarranty(Float warranty) {
		this.warranty = warranty;
	}

	public Float getCustomerLeadTime() {
		return customerLeadTime;
	}

	public void setCustomerLeadTime(Float customerLeadTime) {
		this.customerLeadTime = customerLeadTime;
	}

	public AccountTax getCustomerTaxes() {
		return customerTaxes;
	}

	public void setCustomerTaxes(AccountTax customerTaxes) {
		this.customerTaxes = customerTaxes;
	}

	public AccountTax getSupplierTaxes() {
		return supplierTaxes;
	}

	public void setSupplierTaxes(AccountTax supplierTaxes) {
		this.supplierTaxes = supplierTaxes;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<Partner> getPartners() {
		return partners;
	}

	public void setPartners(Set<Partner> partners) {
		this.partners = partners;
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
