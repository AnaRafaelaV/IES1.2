/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weatherradar;

/**
 *
 * @author ana
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("data")
    @Expose
    private List<CityDetails> data = null;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<CityDetails> getData() {
        return data;
    }

    public void setData(List<CityDetails> data) {
        this.data = data;
    }

}