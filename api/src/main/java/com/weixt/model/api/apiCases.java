package com.weixt.model.api;

public class apiCases {

    private Integer id;
    private String api;
    private String api_params;
    private String expected;
    private String belongs;

    @Override
    public String toString() {
        return "apiCases{" +
                "id=" + id +
                ", api='" + api + '\'' +
                ", api_params='" + api_params + '\'' +
                ", expected='" + expected + '\'' +
                ", belongs='" + belongs + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getApi_params() {
        return api_params;
    }

    public void setApi_params(String api_params) {
        this.api_params = api_params;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getBelongs() {
        return belongs;
    }

    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }
}
