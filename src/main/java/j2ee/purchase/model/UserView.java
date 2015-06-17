package j2ee.purchase.model;


import j2ee.purchase.utils.utils;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

public class UserView {

	@Id
	@Column(name = "user_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	private Boolean active;

	private String create_date;
	private String username;
	private String email;
	private String password;
	private String salt;
	private String user_type;
	private String login_date;

	public UserView() {

	}

	public UserView(String create_date, String username, String email,
			String password, String salt, String user_type, String login_date) {
		super();
		this.create_date = create_date;
		this.username = username;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.user_type = user_type;
		this.login_date = login_date;
	}
	
	public UserView(Date create_date, String username, String email,
			String password, String salt, String user_type, Date login_date) {
		super();
		this.setCreate_date(create_date);
		this.username = username;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.user_type = user_type;
		this.setLogin_date(login_date);
	}

	@JsonBackReference
	@OneToMany(mappedBy = "user")
	private Set<Partner> partners;

	public String getId() {
		return id;
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
	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		String create_date_convert = "";
		if (create_date != null) {

			create_date_convert = utils.formatDate.format(create_date);
		}
		this.create_date = create_date_convert;
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

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getLogin_date() {
		return login_date;
	}

	public void setLogin_date(Date login_date) {
		String login_date_convert = "";
		if (login_date != null) {
			login_date_convert = utils.formatDate.format(login_date);
		}
		this.login_date = login_date_convert;
	}
}
