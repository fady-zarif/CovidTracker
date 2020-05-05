
package com.fadyz.CovidTracker.Models;


import com.google.gson.annotations.SerializedName;

public class PaginationMeta {

    @SerializedName("currentPage")
    private Long mCurrentPage;
    @SerializedName("currentPageSize")
    private Long mCurrentPageSize;
    @SerializedName("totalPages")
    private Long mTotalPages;
    @SerializedName("totalRecords")
    private Long mTotalRecords;

    public Long getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(Long currentPage) {
        mCurrentPage = currentPage;
    }

    public Long getCurrentPageSize() {
        return mCurrentPageSize;
    }

    public void setCurrentPageSize(Long currentPageSize) {
        mCurrentPageSize = currentPageSize;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

    public Long getTotalRecords() {
        return mTotalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        mTotalRecords = totalRecords;
    }

}
