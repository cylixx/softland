package com.softland.example.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
public class Employee {
 
    private int id;
    private String name;
//    private LocalDate joiningDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date joiningDate;
    private BigDecimal salary;
    private String ssn;
 
    
    public Employee() {
		super();
	}

	public Employee(String name, Date joiningDate, BigDecimal salary, String ssn) {
		super();
		this.name = name;
		this.joiningDate = joiningDate;
		this.salary = salary;
		this.ssn = ssn;
	}

	public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public BigDecimal getSalary() {
        return salary;
    }
 
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
 
    public String getSsn() {
        return ssn;
    }
 
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", joiningDate=" + joiningDate + ", salary=" + salary
				+ ", ssn=" + ssn + "]";
	}
    
}
