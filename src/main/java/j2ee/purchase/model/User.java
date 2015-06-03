package j2ee.purchase.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2946042897320611533L;

	@Id
	@Column(name = "user_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	private Boolean active;

	// @ManyToOne
	// @JoinColumn(name = "company_id")
	// private Company company;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Company> companies;

	private Date create_date;
	private String username;
	private String email;
	private String password;
	private String salt;
	private Integer user_type;
	private Date login_date;

	// @ManyToOne
	// @JoinColumn(name = "partner_id")
	// private Partner partner;

	@JsonBackReference
	@OneToMany(mappedBy = "user")
	private Set<Partner> partners;

	public String getId() {
		return id;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	// public Company getCompany() {
	// return company;
	// }
	//
	// public void setCompany(Company company) {
	// this.company = company;
	// }

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getUser_type() {
		return user_type;
	}

	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}

	public Date getLogin_date() {
		return login_date;
	}

	public void setLogin_date(Date login_date) {
		this.login_date = login_date;
	}

	// public Partner getPartner() {
	// return partner;
	// }
	//
	// public void setPartner(Partner partner) {
	// this.partner = partner;
	// }

	public Set<Partner> getPartners() {
		return partners;
	}

	public void setPartners(Set<Partner> partners) {
		this.partners = partners;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", User Name: " + username;

	}
}
