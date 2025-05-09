package com.rohit.hibernate.HibernateApp;

// JPA annotation to mark this class as an Entity mapped to a DB table
import jakarta.persistence.Entity;

// Marks the primary key field in this entity
import jakarta.persistence.Id;

@Entity // Marks this class as a persistent entity (mapped to a DB table named 'Book')
public class Book {

	@Id // This field will act as the primary key in the database table
	private String name; // Book name (used as primary key here)

	// Author name of the book
	private String aname;

	// Publisher name of the book
	private String pname;

	// Price of the book
	private int price;

	// --- Getters and Setters ---

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// --- toString method to print Book object in a readable format ---
	@Override
	public String toString() {
		return "Book [name=" + name 
				+ ", aname=" + aname 
				+ ", pname=" + pname 
				+ ", price=" + price 
				+ ", getName()=" + getName() 
				+ ", getAname()=" + getAname()
				+ ", getPname()=" + getPname()
				+ ", getPrice()=" + getPrice()
				+ ", getClass()=" + getClass() 
				+ ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
