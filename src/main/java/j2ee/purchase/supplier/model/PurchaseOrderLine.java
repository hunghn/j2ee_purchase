package j2ee.purchase.supplier.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASEORDERLINE")
public class PurchaseOrderLine {

	@Id
	@Column(name = "purchase_order_line_id")
	private Integer id;

	private String name;
	private Float price_unit;
	private String state;
	private Float product_quantity;
	private Float product_uom;
	private Boolean invoiced;

	@ManyToOne
	@JoinColumn(name = "purchase_order_id")
	private PurchaseOrder purchase_order;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "partner_id")
	private Partner partner;

	@OneToMany(mappedBy = "purchase_order_line")
	private Set<StockMove> stock_moves;

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

	public PurchaseOrder getPurchase_order() {
		return purchase_order;
	}

	public void setPurchase_order(PurchaseOrder purchase_order) {
		this.purchase_order = purchase_order;
	}

	public Float getPrice_unit() {
		return price_unit;
	}

	public void setPrice_unit(Float price_unit) {
		this.price_unit = price_unit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Float product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Float getProduct_uom() {
		return product_uom;
	}

	public void setProduct_uom(Float product_uom) {
		this.product_uom = product_uom;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Boolean getInvoiced() {
		return invoiced;
	}

	public void setInvoiced(Boolean invoiced) {
		this.invoiced = invoiced;
	}

	public Set<StockMove> getStock_moves() {
		return stock_moves;
	}

	public void setStock_moves(Set<StockMove> stock_moves) {
		this.stock_moves = stock_moves;
	}

}
