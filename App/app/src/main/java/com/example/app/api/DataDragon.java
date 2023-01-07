package com.example.app.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class DataDragon {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("data")
    @Expose
    private Map<String, Champion> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Champion> getData() {
        return data;
    }

    public void setData(Map<String, Champion> data) {
        this.data = data;
    }

}
