package com.webcm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="contact")
public class Contact {

	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="contact_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="id", unique=true, nullable=false)
	private long id;
	
	@NotNull(message="Required input")
	//@Pattern(regexp="[a-zA-Z]+", message="Letters A-Z only")			//gave up on @Pattern on account of special characters
	@Size(min=2, max=20, message="Required input (2-20 characters)")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="Required input")
	//@Pattern(regexp="[a-zA-Z]+", message="Letters A-Z only")			//gave up on @Pattern on account of special characters
	@Size(min=2, max=50, message="Required input (2-50 characters)")
	@Column(name="last_name")
	private String lastName;

	@NotNull(message="Required input")
	@Pattern(regexp="[\\d]+", message="Digits 0-9 only")
	@Size(min=6, max=13, message="Required input (6-13 characters)")
	@Column(name="phone")
	private String phone;
	
	//@Email(message="Please provide a valid email address")			//removed to allow empty field
	@Size(max=50, message="Max input 50 characters")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	@Column(name="email")
	private String email;

	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Sex sex;
	
	public Contact() {
	}

	public Contact(String firstName, String lastName, String phone, String email, Address address, Sex sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.sex = sex;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return String.format("Contact [id=%s, firstName=%s, lastName=%s, phone=%s, email=%s, address=%s, sex=%s]", id,
				firstName, lastName, phone, email, address, sex);
	}

}
