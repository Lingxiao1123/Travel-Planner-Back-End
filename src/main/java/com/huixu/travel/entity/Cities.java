package com.huixu.travel.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cities")

public class Cities implements Serializable {

    private static final long serialVersionUID = 38054036111L;

    @Id
    private int id;
    private String name;
    private String imageUrl;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<POIs> poiList;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<POIs> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<POIs> poiList) {
        this.poiList = poiList;
    }
}
