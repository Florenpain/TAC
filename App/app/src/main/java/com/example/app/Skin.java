package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Skin {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("chromas")
    @Expose
    private Boolean chromas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChromas() {
        return chromas;
    }

    public void setChromas(Boolean chromas) {
        this.chromas = chromas;
    }

}