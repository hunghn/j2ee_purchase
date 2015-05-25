package j2ee.purchase.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "COMPANY")
public class Company {

	@Id
	@Column(name = "company_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String email;
	private String phone;
	private String address;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "COMPANY_USER", joinColumns = { @JoinColumn(name = "company_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	private Set<User> users;

	@OneToMany(mappedBy = "company")
	private Set<Partner> partners;

	@OneToMany(mappedBy = "company")
	private Set<PurchaseOrder> purchase_orders;

	@OneToMany(mappedBy = "company")
	private Set<PurchaseOrderLine> purchase_order_lines;

	@OneToMany(mappedBy = "company")
	private Set<StockMove> stock_moves;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
