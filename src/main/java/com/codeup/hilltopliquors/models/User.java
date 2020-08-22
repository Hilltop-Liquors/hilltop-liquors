package com.codeup.hilltopliquors.models;

import javax.persistence.*;
import java.util.Collection;
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

//    ## With the new roles table we no longer need these booleans
//    @Column(length = 20, nullable = false, columnDefinition = "default 'false'")
//    private boolean isAdmin;
//
//    @Column(length = 20, nullable = false)
//    private boolean isEmployee;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

//    Adding the mapping table to connect users and roles
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    public User(long id, String first_name, String last_name, String username, String email, String password, String phone, boolean sms_consent) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sms_consent = sms_consent;
    }

    public User() {
    }

//    ## I do not believe we need this anymore due to the way I have set up our security
//    public User(User copy) {
//        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
//        first_name = copy.first_name;
//        last_name = copy.last_name;
//        username = copy.username;
//        email = copy.email;
//        password = copy.password;
//        phone = copy.phone;
//        sms_consent = copy.sms_consent;
//        isAdmin = copy.isAdmin;
//        isEmployee = copy.isEmployee;
//    }

    public User(long id, String first_name, String last_name, String username, String email, String password, String phone, boolean sms_consent, List<Order> orders) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sms_consent = sms_consent;
        this.orders = orders;
    }

    public User(String first_name, String last_name, String username, String email, String password, String phone, boolean sms_consent) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sms_consent = sms_consent;
    }

    public User(String first_name, String last_name, String username, String email, String password, String phone, boolean sms_consent, List<Order> orders, Collection<Role> roles) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sms_consent = sms_consent;
        this.orders = orders;
        this.roles = roles;
    }


//    ## I believe this is our targeted constructor for a new user
    public User(String first_name, String last_name, String username, String email, String password, String phone, boolean sms_consent, Collection<Role> roles) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sms_consent = sms_consent;
        this.roles = roles;
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

//    ## Added these getters and setters
    public boolean isSms_consent() {
        return sms_consent;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sms_consent=" + sms_consent +
                ", orders=" + orders +
                ", roles=" + roles +
                '}';
    }
}
