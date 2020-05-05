
package com.fadyz.CovidTracker.Models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class CountriesData {

    @SerializedName("last_update")
    private String mLastUpdate;
    @SerializedName("paginationMeta")
    private PaginationMeta mPaginationMeta;
    @SerializedName("rows")
    private ArrayList<CountryModel> mCountryModels;

    public String getLastUpdate() {
        return mLastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        mLastUpdate = lastUpdate;
    }

    public PaginationMeta getPaginationMeta() {
        return mPaginationMeta;
    }

    public void setPaginationMeta(PaginationMeta paginationMeta) {
        mPaginationMeta = paginationMeta;
    }

    public ArrayList<CountryModel> getRows() {
        return mCountryModels;
    }

    public void setRows(ArrayList<CountryModel> countryModels) {
        mCountryModels = countryModels;
    }

}
