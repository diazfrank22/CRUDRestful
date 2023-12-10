package com.crud.restfull.domain.entities;


public class Phones {
    private Long phoneId;
    private  String number;
    private  String citycode;
    private  String contrycode;

    public Phones(Long phoneId, String number, String citycode, String contrycode) {
        this.phoneId = phoneId;
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }
}
