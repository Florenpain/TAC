package com.example.app.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Spell {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("tooltip")
    @Expose
    private String tooltip;
    @SerializedName("maxrank")
    @Expose
    private Integer maxrank;
    @SerializedName("cooldown")
    @Expose
    private List<Integer> cooldown = null;
    @SerializedName("cooldownBurn")
    @Expose
    private String cooldownBurn;
    @SerializedName("cost")
    @Expose
    private List<Integer> cost = null;
    @SerializedName("costBurn")
    @Expose
    private String costBurn;
    @SerializedName("effect")
    @Expose
    private List<Object> effect = null;
    @SerializedName("effectBurn")
    @Expose
    private List<Object> effectBurn = null;
    @SerializedName("vars")
    @Expose
    private List<Object> vars = null;
    @SerializedName("costType")
    @Expose
    private String costType;
    @SerializedName("maxammo")
    @Expose
    private String maxammo;
    @SerializedName("range")
    @Expose
    private List<Integer> range = null;
    @SerializedName("rangeBurn")
    @Expose
    private String rangeBurn;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("resource")
    @Expose
    private String resource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public Integer getMaxrank() {
        return maxrank;
    }

    public void setMaxrank(Integer maxrank) {
        this.maxrank = maxrank;
    }

    public List<Integer> getCooldown() {
        return cooldown;
    }

    public void setCooldown(List<Integer> cooldown) {
        this.cooldown = cooldown;
    }

    public String getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public List<Integer> getCost() {
        return cost;
    }

    public void setCost(List<Integer> cost) {
        this.cost = cost;
    }

    public String getCostBurn() {
        return costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public List<Object> getEffect() {
        return effect;
    }

    public void setEffect(List<Object> effect) {
        this.effect = effect;
    }

    public List<Object> getEffectBurn() {
        return effectBurn;
    }

    public void setEffectBurn(List<Object> effectBurn) {
        this.effectBurn = effectBurn;
    }

    public List<Object> getVars() {
        return vars;
    }

    public void setVars(List<Object> vars) {
        this.vars = vars;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getMaxammo() {
        return maxammo;
    }

    public void setMaxammo(String maxammo) {
        this.maxammo = maxammo;
    }

    public List<Integer> getRange() {
        return range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }

    public String getRangeBurn() {
        return rangeBurn;
    }

    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

}