package com.webcm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	

	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="city_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="id", unique=true, nullable=false)
	private long cityid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Country country;

	public City() {
	}

	public City(String name, String zipCode, Country country) {
		this.name = name;
		this.zipCode = zipCode;
		this.country = country;
	}

	public long getCityid() {
		return cityid;
	}

	public void setCityid(long cityid) {
		this.cityid = cityid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return name + ", " + zipCode + ", " +country;
	}
	
}