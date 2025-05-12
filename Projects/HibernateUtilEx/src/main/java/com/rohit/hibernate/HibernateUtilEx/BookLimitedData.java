package com.rohit.hibernate.HibernateUtilEx;

public class BookLimitedData {
    
	private int id;
    private String name;
    private int price;
    private String authName;
    
    
	public BookLimitedData(int id, String name, int price, String authName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.authName = authName;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getAuthName() {
		return authName;
	}
	@Override
	public String toString() {
		return "BookLimitedData [id=" + id + ", name=" + name + ", price=" + price + ", authName=" + authName + "]";
	}	
}
