package j2ee.purchase.supplier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCKMOVE")
public class StockMove {

	@Id
	@Column(name = "stock_move_id")
	private Integer id;
	private String origin;
	private Float product_uos_qty;
	private Double price_unit;
	private Float product_uom_qty;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	private Float product_qty;
	private String name;
	private String procure_method;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "partner_id")
	private Partner partner;

	@ManyToOne
	@JoinColumn(name = "purchase_order_line_id")
	private PurchaseOrderLine purchase_order_line;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Float getProduct_uos_qty() {
		return product_uos_qty;
	}

	public void setProduct_uos_qty(Float product_uos_qty) {
		this.product_uos_qty = product_uos_qty;
	}

	public Double getPrice_unit() {
		return price_unit;
	}

	public void setPrice_unit(Double price_unit) {
		this.price_unit = price_unit;
	}

	public Float getProduct_uom_qty() {
		return product_uom_qty;
	}

	public void setProduct_uom_qty(Float product_uom_qty) {
		this.product_uom_qty = product_uom_qty;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Float getProduct_qty() {
		return product_qty;
	}

	public void setProduct_qty(Float product_qty) {
		this.product_qty = product_qty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProcure_method() {
		return procure_method;
	}

	public void setProcure_method(String procure_method) {
		this.procure_method = procure_method;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public PurchaseOrderLine getPurchase_order_line() {
		return purchase_order_line;
	}

	public void setPurchase_order_line(PurchaseOrderLine purchase_order_line) {
		this.purchase_order_line = purchase_order_line;
	}

}
