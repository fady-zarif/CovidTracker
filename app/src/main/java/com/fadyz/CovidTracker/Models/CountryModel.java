
package com.fadyz.CovidTracker.Models;

import com.google.gson.annotations.SerializedName;


public class CountryModel {

    @SerializedName("active_cases")
    private String mActiveCases;
    @SerializedName("cases_per_mill_pop")
    private String mCasesPerMillPop;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("country_abbreviation")
    private String mCountryAbbreviation;
    @SerializedName("flag")
    private String mFlag;
    @SerializedName("new_cases")
    private String mNewCases;
    @SerializedName("new_deaths")
    private String mNewDeaths;
    @SerializedName("serious_critical")
    private String mSeriousCritical;
    @SerializedName("total_cases")
    private String mTotalCases;
    @SerializedName("total_deaths")
    private String mTotalDeaths;
    @SerializedName("total_recovered")
    private String mTotalRecovered;

    public String getActiveCases() {
        return mActiveCases;
    }

    public void setActiveCases(String activeCases) {
        mActiveCases = activeCases;
    }

    public String getCasesPerMillPop() {
        return mCasesPerMillPop;
    }

    public void setCasesPerMillPop(String casesPerMillPop) {
        mCasesPerMillPop = casesPerMillPop;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCountryAbbreviation() {
        return mCountryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        mCountryAbbreviation = countryAbbreviation;
    }

    public String getFlag() {
        return mFlag;
    }

    public void setFlag(String flag) {
        mFlag = flag;
    }

    public String getNewCases() {
        return mNewCases;
    }

    public void setNewCases(String newCases) {
        mNewCases = newCases;
    }

    public String getNewDeaths() {
        return mNewDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        mNewDeaths = newDeaths;
    }

    public String getSeriousCritical() {
        return mSeriousCritical;
    }

    public void setSeriousCritical(String seriousCritical) {
        mSeriousCritical = seriousCritical;
    }

    public String getTotalCases() {
        return mTotalCases;
    }

    public void setTotalCases(String totalCases) {
        mTotalCases = totalCases;
    }

    public String getTotalDeaths() {
        return mTotalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        mTotalDeaths = totalDeaths;
    }

    public String getTotalRecovered() {
        return mTotalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        mTotalRecovered = totalRecovered;
    }

}
