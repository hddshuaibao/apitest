package com.weixt.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CostTypeConfig {

    private BigInteger id;
    private int is_show;
    private String title;
    private int orderid;
    private int campusid;
    private int creatorid;
    private String create_time;
    private int updatorid;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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

    public int getUpdatorid() {
        return updatorid;
    }

    public void setUpdatorid(int updatorid) {
        this.updatorid = updatorid;
    }



    @Override
    public String toString(){
        String isshow = "true";
        String id = String.valueOf(getId());
        if(is_show==1){

        }else{
            isshow = "false";
        }

        return (
                "{\"costTypeid\":\""+id+"\","+
                        "\"orderid\":"+orderid+","+
                        "\"title\":\""+title+"\","+
                        "\"isShow\":"+isshow+"}"


                );
    }
}
