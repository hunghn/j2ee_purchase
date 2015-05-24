package j2ee.purchase.supplier.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASEORDER")
public class PurchaseOrder {

	@Id
	@Column(name = "purchase_order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "currency_id")
	private Currency currency;

	@ManyToOne
	@JoinColumn(name = "partner_id")
	private Partner partner;

	@ManyToOne
	@JoinColumn(name = "stock_location_id")
	private StockLocation stock_location;

	private String name;
	private Date date_approve;
	private String invoice_method;
	private Float amount_tax;
	private Float amount_total;
	private Float amount_untaxed;
	private String note;
	private Date bid_date;
	private Date bid_validity;
	private Date date_order;
	
	@OneToMany(mappedBy="purchase_order")
	private Set<PurchaseOrderLine> purchase_order_lines;

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getDate_order() {
		return date_order;
	}

	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getDate_approve() {
		return date_approve;
	}

	public void setDate_approve(Date date_approve) {
		this.date_approve = date_approve;
	}

	public String getInvoice_method() {
		return invoice_method;
	}

	public void setInvoice_method(String invoice_method) {
		this.invoice_method = invoice_method;
	}

	public Float getAmount_tax() {
		return amount_tax;
	}

	public void setAmount_tax(Float amount_tax) {
		this.amount_tax = amount_tax;
	}

	public Float getAmount_total() {
		return amount_total;
	}

	public void setAmount_total(Float amount_total) {
		this.amount_total = amount_total;
	}

	public Float getAmount_untaxed() {
		return amount_untaxed;
	}

	public void setAmount_untaxed(Float amount_untaxed) {
		this.amount_untaxed = amount_untaxed;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Date getBid_date() {
		return bid_date;
	}

	public void setBid_date(Date bid_date) {
		this.bid_date = bid_date;
	}

	public Date getBid_validity() {
		return bid_validity;
	}

	public void setBid_validity(Date bid_validity) {
		this.bid_validity = bid_validity;
	}

	public StockLocation getStock_location() {
		return stock_location;
	}

	public void setStock_location(StockLocation stock_location) {
		this.stock_location = stock_location;
	}

}
