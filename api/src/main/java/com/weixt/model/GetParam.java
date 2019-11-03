package com.weixt.model;

import lombok.Data;

@Data
public class GetParam {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApiid() {
        return apiid;
    }

    public void setApiid(int apiid) {
        this.apiid = apiid;
    }

    public String getApiparams() {
        return apiparams;
    }

    public void setApiparams(String apiparams) {
        this.apiparams = apiparams;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getExpected() {
        return expect;
    }

    public void setExpected(String expected) {
        this.expect = expected;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    private int apiid;
    private String apiparams;
    private String cases;
    private String expect;
    private String api;

}
