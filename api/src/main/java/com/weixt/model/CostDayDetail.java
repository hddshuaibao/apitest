package com.weixt.model;

import java.math.BigInteger;
import java.util.Date;

public class CostDayDetail {

    private BigInteger id;
    private BigInteger typeid;
    private float money;
    private Date record_date;
    private BigInteger recordid;
    private Integer campusid;
    private Date creatorid;

    @Override
    public String toString() {
        return "CostDayDetail{" +
                "typeid=" + typeid +
                ", money=" + money +
                ", record_date=" + record_date +
                ", recordid=" + recordid +
                '}';
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getTypeid() {
        return typeid;
    }

    public void setTypeid(BigInteger typeid) {
        this.typeid = typeid;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public BigInteger getRecordid() {
        return recordid;
    }

    public void setRecordid(BigInteger recordid) {
        this.recordid = recordid;
    }

    public Integer getCampusid() {
        return campusid;
    }

    public void setCampusid(Integer campusid) {
        this.campusid = campusid;
    }

    public Date getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Date creatorid) {
        this.creatorid = creatorid;
    }
}
