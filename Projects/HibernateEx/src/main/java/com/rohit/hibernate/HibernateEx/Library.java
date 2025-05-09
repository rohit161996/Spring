package com.rohit.hibernate.HibernateEx;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

// Marks this class as a JPA entity (mapped to a table in the DB)
@Entity

// Maps the entity to the table named 'library_info' in the database
@Table(name="library_info")
public class Library {

    // Marks this field as the primary key
    @Id
    
    // Specifies auto-generation strategy for primary key (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lib_id;

    // Maps this field to a column named 'lib_cost' with constraints
    @Column(name = "lib_cost", nullable = false, length = 100)
    private int cost;

    // Default mapping to a column named 'laname'
    private String laname;

    // Default mapping to a column named 'lpname'
    private String lpname;

    // Field will not be stored in the DB (used for temporary data only)
    @Transient
    private int sections;

    // Getter and setter for lib_id
    public int getLib_id() {
        return lib_id;
    }

    public void setLib_id(int lib_id) {
        this.lib_id = lib_id;
    }

    // Getter and setter for cost
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // Getter and setter for laname
    public String getLaname() {
        return laname;
    }

    public void setLaname(String laname) {
        this.laname = laname;
    }

    // Getter and setter for lpname
    public String getLpname() {
        return lpname;
    }

    public void setLpname(String lpname) {
        this.lpname = lpname;
    }

    // Getter and setter for sections (transient field)
    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    // Overridden toString() method to display object details
    @Override
    public String toString() {
        return "Library [lib_id=" + lib_id 
        		+ ", cost=" + cost 
        		+ ", laname=" + laname 
        		+ ", lpname=" + lpname
                + ", sections=" + sections 
                + ", getLib_id()=" + getLib_id() 
                + ", getCost()=" + getCost()
                + ", getLaname()=" + getLaname() 
                + ", getLpname()=" + getLpname() 
                + ", getSections()=" + getSections()
                + ", getClass()=" + getClass() 
                + ", hashCode()=" + hashCode() 
                + ", toString()=" + super.toString()
                + "]";
    }
}
