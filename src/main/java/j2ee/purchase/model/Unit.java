package j2ee.purchase.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "UNIT")
public class Unit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "unit_id", columnDefinition = "CHAR(32)")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	private String name;
	private Boolean active;
	private Float rouding;
	
	@JsonBackReference
	@OneToMany(mappedBy = "unit")
	private Set<Product> products;
	
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
	public Float getRouding() {
		return rouding;
	}
	public void setRouding(Float rouding) {
		this.rouding = rouding;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Unit [id=" + id + ", name=" + name + ", active=" + active
				+ ", rouding=" + rouding + "]";
	}
	
	
}
