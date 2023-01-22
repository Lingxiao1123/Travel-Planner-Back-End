package com.huixu.travel.entity;


import javax.persistence.*;
import java.awt.*;
import java.util.List;
@Entity
@Table(name = "user")
public class User {
    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Plan> planList;

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
