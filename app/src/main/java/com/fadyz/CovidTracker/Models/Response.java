
package com.fadyz.CovidTracker.Models;


import com.google.gson.annotations.SerializedName;


public class Response {

    @SerializedName("data")
    private CountriesData mCountriesData;
    @SerializedName("status")
    private String mStatus;

    public CountriesData getData() {
        return mCountriesData;
    }

    public void setData(CountriesData countriesData) {
        mCountriesData = countriesData;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
