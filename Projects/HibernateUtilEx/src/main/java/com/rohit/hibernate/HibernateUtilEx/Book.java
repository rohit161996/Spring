package com.rohit.hibernate.HibernateUtilEx;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity  // Marks this class as a JPA entity mapped to a database table (default name = 'Book')
public class Book {

    @Id  // Primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in DB
    private int id;

    @Column(nullable = false, length = 100) // Not null, max length = 100 chars
    private String name;

    private int price;

    @Column(nullable = false, length = 100) // Not null author name, length limit
    private String authName;

    private String pubName; // Publisher name (nullable by default)

    @Transient // Will not be persisted in DB (useful for derived or temp fields)
    private int pages;

    @Temporal(TemporalType.TIMESTAMP) // Specifies that `dop` should be stored as full timestamp
    // Other options:
    // @Temporal(TemporalType.DATE) -> only date
    // @Temporal(TemporalType.TIME) -> only time
    private Date dop;

    @Lob // For large binary data (e.g., image, PDF, etc.)
    private byte[] image;

    @Lob // Another LOB for large content, e.g., text or file
    private byte[] content;

    // ----- Getters and Setters -----

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getDop() {
        return dop;
    }

    public void setDop(Date dop) {
        this.dop = dop;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Book [id=" + id 
            + ", name=" + name 
            + ", price=" + price 
            + ", authName=" + authName 
            + ", pubName=" + pubName 
            + ", pages=" + pages 
            + ", dop=" + dop 
            + ", image=" + Arrays.toString(image) 
            + ", content=" + Arrays.toString(content) 
            + ", getId()=" + getId() 
            + ", getName()=" + getName() 
            + ", getPrice()=" + getPrice() 
            + ", getAuthName()=" + getAuthName() 
            + ", getPubName()=" + getPubName() 
            + ", getPages()=" + getPages() 
            + ", getDop()=" + getDop() 
            + ", getImage()=" + Arrays.toString(getImage()) 
            + ", getContent()=" + Arrays.toString(getContent()) 
            + ", getClass()=" + getClass() 
            + ", hashCode()=" + hashCode() 
            + ", toString()=" + super.toString() 
            + "]";
    }
}
