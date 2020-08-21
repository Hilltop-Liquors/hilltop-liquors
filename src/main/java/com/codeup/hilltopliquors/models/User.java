package com.codeup.hilltopliquors.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String first_name;

    @Column(length = 50, nullable = false)
    private String last_name;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String phone;

    @Column(length = 50, nullable = false)
    private boolean sms_consent;

    @Column(length = 20, nullable = false)
    private boolean isAdmin;

    @Column(length = 20, nullable = false)
    private boolean isEmployee;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    public User(long id, String first_name, String last_name, String username, String email, String password, String phone, boolean sms_consent, boolean isAdmin, boolean isEmployee) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sms_consent = sms_consent;
        this.isAdmin = isAdmin;
        this.isEmployee = isEmployee;
    }

    public User() {
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        first_name = copy.first_name;
        last_name = copy.last_name;
        username = copy.username;
        email = copy.email;
        password = copy.password;
        phone = copy.phone;
        sms_consent = copy.sms_consent;
        isAdmin = copy.isAdmin;
        isEmployee = copy.isEmployee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getSms_consent() {
        return sms_consent;
    }

    public void setSms_consent(boolean sms_consent) {
        this.sms_consent = sms_consent;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }
}
