package com.softland.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datereg;

	private BigDecimal folio;

	private String name;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getDatereg() {
		return this.datereg;
	}

	public void setDatereg(Date datereg) {
		this.datereg = datereg;
	}

	public BigDecimal getFolio() {
		return this.folio;
	}

	public void setFolio(BigDecimal folio) {
		this.folio = folio;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "User [id=" + id + ", address=" + address + ", birthday=" + birthday + ", dateReg=" + datereg + ", folio=" + folio + ", name=" + name + "]";
    }

}