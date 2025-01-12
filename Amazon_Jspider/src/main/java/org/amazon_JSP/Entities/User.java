package org.amazon_JSP.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
public class User {
    @Id
    @Column
    private int id;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 4)
    private String password;

    @Column
    private String city;

    @Column(nullable = false, unique = true)
    private String mobilenumber;

    public User() {}

    public User(int id, String name, String email, String password, String city, String mobilenumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.mobilenumber = mobilenumber;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }
    

    public void setMobileNumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }



    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", city=" + city
                + ", mobilenumber=" + mobilenumber + "]";
    }
}
