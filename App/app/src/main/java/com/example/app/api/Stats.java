package com.example.app.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("hp")
    @Expose
    private float hp;
    @SerializedName("hpperlevel")
    @Expose
    private float hpperlevel;
    @SerializedName("mp")
    @Expose
    private float mp;
    @SerializedName("mpperlevel")
    @Expose
    private float mpperlevel;
    @SerializedName("movespeed")
    @Expose
    private float movespeed;
    @SerializedName("armor")
    @Expose
    private float armor;
    @SerializedName("armorperlevel")
    @Expose
    private Double armorperlevel;
    @SerializedName("spellblock")
    @Expose
    private float spellblock;
    @SerializedName("spellblockperlevel")
    @Expose
    private Double spellblockperlevel;
    @SerializedName("attackrange")
    @Expose
    private float attackrange;
    @SerializedName("hpregen")
    @Expose
    private float hpregen;
    @SerializedName("hpregenperlevel")
    @Expose
    private float hpregenperlevel;
    @SerializedName("mpregen")
    @Expose
    private float mpregen;
    @SerializedName("mpregenperlevel")
    @Expose
    private float mpregenperlevel;
    @SerializedName("crit")
    @Expose
    private float crit;
    @SerializedName("critperlevel")
    @Expose
    private float critperlevel;
    @SerializedName("attackdamage")
    @Expose
    private float attackdamage;
    @SerializedName("attackdamageperlevel")
    @Expose
    private float attackdamageperlevel;
    @SerializedName("attackspeedperlevel")
    @Expose
    private Double attackspeedperlevel;
    @SerializedName("attackspeed")
    @Expose
    private Double attackspeed;

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getHpperlevel() {
        return hpperlevel;
    }

    public void setHpperlevel(float hpperlevel) {
        this.hpperlevel = hpperlevel;
    }

    public float getMp() {
        return mp;
    }

    public void setMp(float mp) {
        this.mp = mp;
    }

    public float getMpperlevel() {
        return mpperlevel;
    }

    public void setMpperlevel(float mpperlevel) {
        this.mpperlevel = mpperlevel;
    }

    public float getMovespeed() {
        return movespeed;
    }

    public void setMovespeed(float movespeed) {
        this.movespeed = movespeed;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public Double getArmorperlevel() {
        return armorperlevel;
    }

    public void setArmorperlevel(Double armorperlevel) {
        this.armorperlevel = armorperlevel;
    }

    public float getSpellblock() {
        return spellblock;
    }

    public void setSpellblock(float spellblock) {
        this.spellblock = spellblock;
    }

    public Double getSpellblockperlevel() {
        return spellblockperlevel;
    }

    public void setSpellblockperlevel(Double spellblockperlevel) {
        this.spellblockperlevel = spellblockperlevel;
    }

    public float getAttackrange() {
        return attackrange;
    }

    public void setAttackrange(float attackrange) {
        this.attackrange = attackrange;
    }

    public float getHpregen() {
        return hpregen;
    }

    public void setHpregen(float hpregen) {
        this.hpregen = hpregen;
    }

    public float getHpregenperlevel() {
        return hpregenperlevel;
    }

    public void setHpregenperlevel(float hpregenperlevel) {
        this.hpregenperlevel = hpregenperlevel;
    }

    public float getMpregen() {
        return mpregen;
    }

    public void setMpregen(float mpregen) {
        this.mpregen = mpregen;
    }

    public float getMpregenperlevel() {
        return mpregenperlevel;
    }

    public void setMpregenperlevel(float mpregenperlevel) {
        this.mpregenperlevel = mpregenperlevel;
    }

    public float getCrit() {
        return crit;
    }

    public void setCrit(float crit) {
        this.crit = crit;
    }

    public float getCritperlevel() {
        return critperlevel;
    }

    public void setCritperlevel(float critperlevel) {
        this.critperlevel = critperlevel;
    }

    public float getAttackdamage() {
        return attackdamage;
    }

    public void setAttackdamage(float attackdamage) {
        this.attackdamage = attackdamage;
    }

    public float getAttackdamageperlevel() {
        return attackdamageperlevel;
    }

    public void setAttackdamageperlevel(float attackdamageperlevel) {
        this.attackdamageperlevel = attackdamageperlevel;
    }

    public Double getAttackspeedperlevel() {
        return attackspeedperlevel;
    }

    public void setAttackspeedperlevel(Double attackspeedperlevel) {
        this.attackspeedperlevel = attackspeedperlevel;
    }

    public Double getAttackspeed() {
        return attackspeed;
    }

    public void setAttackspeed(Double attackspeed) {
        this.attackspeed = attackspeed;
    }

}