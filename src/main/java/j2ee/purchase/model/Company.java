package j2ee.purchase.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1006626122815037638L;

	@Id
	@Column(name = "company_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private String name;
	private String email;
	private String phone;
	private String address;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "COMPANY_USER", joinColumns = { @JoinColumn(name = "company_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	private Set<User> users;

	@JsonBackReference
	@OneToMany(mappedBy = "company")
	private Set<Partner> partners;

	@JsonBackReference
	@OneToMany(mappedBy = "company")
	private Set<PurchaseOrder> purchase_orders;

	@JsonBackReference
	@OneToMany(mappedBy = "company")
	private Set<PurchaseOrderLine> purchase_order_lines;

	@JsonBackReference
	@OneToMany(mappedBy = "company")
	private Set<StockMove> stock_moves;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Partner> getPartners() {
		return partners;
	}

	public void setPartners(Set<Partner> partners) {
		this.partners = partners;
	}

	public Set<PurchaseOrder> getPurchase_orders() {
		return purchase_orders;
	}

	public void setPurchase_orders(Set<PurchaseOrder> purchase_orders) {
		this.purchase_orders = purchase_orders;
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

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name;
	}

}
