package j2ee.purchase.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PARTNER")
public class Partner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2101643258601704291L;

	@Id
	@Column(name = "partner_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	private String comment_text;
	private Date create_date;
	private byte[] image_small;
	private byte[] image;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String display_name;
	private String email;
	private String phone;
	private String mobile;
	private String fax;
	private String website;
	private Boolean is_company;
	private Boolean is_customer;
	private Boolean is_supplier;
	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// @OneToMany(mappedBy = "partner")
	// private Set<User> users;

	@JsonBackReference
	@OneToMany(mappedBy = "partner")
	private Set<PurchaseOrder> purchase_orders;

	@JsonBackReference
	@OneToMany(mappedBy = "partner")
	private Set<PurchaseOrderLine> purchase_order_lines;

	@JsonBackReference
	@OneToMany(mappedBy = "partner")
	private Set<StockMove> stock_moves;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// public Set<User> getUsers() {
	// return users;
	// }
	//
	// public void setUsers(Set<User> users) {
	// this.users = users;
	// }

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

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public byte[] getImage_small() {
		return image_small;
	}

	public void setImage_small(byte[] image_small) {
		this.image_small = image_small;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIs_company() {
		return is_company;
	}

	public void setIs_company(Boolean is_company) {
		this.is_company = is_company;
	}

	public Boolean getIs_customer() {
		return is_customer;
	}

	public void setIs_customer(Boolean is_customer) {
		this.is_customer = is_customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Boolean getIs_supplier() {
		return is_supplier;
	}

	public void setIs_supplier(Boolean is_supplier) {
		this.is_supplier = is_supplier;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name;
	}

}
