
package com.fadyz.CovidTracker.Models;


import com.google.gson.annotations.SerializedName;

public class StatisticsResponse {

    @SerializedName("data")
    private StatisticsData mStatisticsData;
    @SerializedName("status")
    private String mStatus;

    public StatisticsData getData() {
        return mStatisticsData;
    }

    public void setData(StatisticsData statisticsData) {
        mStatisticsData = statisticsData;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
