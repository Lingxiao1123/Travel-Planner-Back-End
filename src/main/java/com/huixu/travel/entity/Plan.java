package com.huixu.travel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plan")
public class Plan {
    //private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @Transient
    private List<List<String>> route;

    @JsonIgnore
    private String routeString;

    @ManyToOne
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<List<String>> getRoute() {
        return route;
    }

    public void setRoute(List<List<String>> route) {
        this.route = route;
    }

    public String getRouteString() {
        return routeString;
    }

    public void setRouteString(String routeString) {
        this.routeString = routeString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String encode(List<List<String>> l){
        if(l==null)
            return null;
        StringBuilder sb = new StringBuilder();
        for(List<String> day : l){
            for(String pid : day){
                sb.append(pid);
                sb.append(',');
            }
            sb.append(";");
        }
        return sb.toString();
    }
    public List<List<String>> decode(String str){
        if(str==null)
            return null;
        List<List<String>> res = new ArrayList<>();
        String[] days = str.split(";");
        for(String day: days){
            List<String> cur = new ArrayList<>();
            for(String pid : day.split(",")){
                cur.add(pid);
            }
            res.add(cur);
        }
        return res;
    }

//    public static void main(String[] args) {
//        Plan test = new Plan();
//        String s = "12,rwer,1234,rqewr,;123,432,5234,12345,;qwerqwe,;";
//        for(List<String> t : test.decode(s)){
//            for(String str : t){
//                System.out.print(str+" ");
//            }
//            System.out.println();
//        }
//        System.out.println(test.encode(test.decode(s)));
//    }

}

