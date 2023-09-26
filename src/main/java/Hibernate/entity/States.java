package Hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class States {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stateCode;
	private String stateName;
	
	@ManyToOne
	@JoinColumn(name="countryCode")
	private Country country;
	public States() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	

}
