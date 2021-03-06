package br.com.estudo.java.jpa.hello;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer implements Serializable{
	
	@SequenceGenerator(			//PostgreSQL
			name="CUSTOMER_SEQUENCE_GENERATOR", sequenceName="sequence_teste"
	)
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO) 		MySQL / HSQLDB
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CUSTOMER_SEQUENCE_GENERATOR")   //PostgreSQL
	
	private long id;
	private String firstName;
	private String lastName;
	
	protected Customer() {}
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s]", id, firstName, lastName);
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
	
	
}
