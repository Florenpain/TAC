package com.example.app.database.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChampionEntity {

    @PrimaryKey
    @NonNull
    private String id;
    private String name;
    private String title;
    private String image;
    private String tags = null;

    public ChampionEntity(String id, String name, String title, String image, String tags) {
        this.name = name;
        this.title = title;
        this.image = image;
        this.tags = tags;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
