package com.webcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="country")
public class Country {


	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="country_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="id", unique=true, nullable=false)
	private long id;
	
	@NotNull(message="Required input")
	@Size(min=2, max=50, message="Required input (2-50 characters)")
	//@Pattern(regexp="[a-zA-Z]+", message="Requires A-Z only")				//gave up on @Pattern on account of special characters
	@Column(name="name")
	private String name;
	
	@NotNull(message="Required input")
	@Pattern(regexp="[a-zA-Z]{2}+", message="Requires 2 letter code")
	@Column(name="alpha_2")
	private String alpha2;

	@NotNull(message="Required input")
	@Pattern(regexp="[a-zA-Z]{3}+", message="Requires 3 letter code")
	@Column(name="alpha_3")
	private String alpha3;

	public Country() {
	}

	public Country(String name, String alpha2, String alpha3) {
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}

	@Override
	public String toString() {
		return name+", "+alpha2+", "+alpha3;
	}

	

	/**
	 * Compares two Country objects (custom equals implementation) 
	 * 
	 * Cross-references the two objects for any matching attribute pair.
	 * Returns true on any match.
	 */
	public boolean compare(Country other) {
		Boolean result=false;
		
		if (id!=other.id){							 		// perform the compare only if IDs are not equal
		if (alpha2.equalsIgnoreCase(other.alpha2)) {
				result=true;}
		if (alpha3.equalsIgnoreCase(other.alpha3)) {
				result=true;}
		if (name.equalsIgnoreCase(other.name)) {
				result=true;}
		}

		return result;
	}

}
