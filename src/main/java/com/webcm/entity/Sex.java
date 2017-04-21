package com.webcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sex")
public class Sex {
	
	@Id
//	@SequenceGenerator(name="pk_sequence",sequenceName="sex_id_seq", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="id", unique=true, nullable=false)
	private long id;

	@Column(name="name")
	private String name;
	
	//private LinkedHashMap<Integer, String> sexoptions;
	
	public Sex() {
	//	sexoptions = new LinkedHashMap<>();
	//	sexoptions.put((int) id, name);
	}
	
	/*public LinkedHashMap<Integer, String> getSexoptions() {
		return sexoptions;
	}*/

	public Sex(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return String.format("Sex [id=%s, name=%s]", id, name);
	}

}
