package com.weixt.model;

import java.math.BigInteger;

public class CostBalance {

    private BigInteger id;
    private float init_balance;
    private int campusid;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public float getInit_balance() {
        return init_balance;
    }

    public void setInit_balance(float init_balance) {
        this.init_balance = init_balance;
    }

    public int getCampusid() {
        return campusid;
    }

    public void setCampusid(int campusid) {
        this.campusid = campusid;
    }

    public int getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(int creatorid) {
        this.creatorid = creatorid;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    private int creatorid;
    private String create_time;

}
