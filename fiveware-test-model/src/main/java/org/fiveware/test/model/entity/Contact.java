package org.fiveware.test.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * Entity class for contact
 * 
 * @author aolidias
 *
 */
@Entity
public class Contact {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String sex;
	
	private boolean single;
	
	private String favoriteMonth;
	
	public Contact(){
		
	}

	public Contact(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public boolean isSingle() {
		return single;
	}
	
	public void setSingle(boolean single) {
		this.single = single;
	}
	
	public String getFavoriteMonth() {
		return favoriteMonth;
	}
	
	public void setFavoriteMonth(String favoriteMonth) {
		this.favoriteMonth = favoriteMonth;
	}
	
	@Override
	public String toString() {
		return "First name " + getFirstName() + ", Last name " + getLastName() + ", sex " + getSex();
	}
}
