package com.fadyz.CovidTracker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fadyz.CovidTracker.Models.CountryModel
import com.fadyz.CovidTracker.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_view.view.*

class BottomSheetView(private val countryModel: CountryModel) : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_view, container, false)
        setView(view, countryModel)
        return view;

    }

    override fun getTheme(): Int = R.style.BaseBottomSheetDialog


    private fun setView(view: View, countryModel: CountryModel) {
        view.tvCountryName.text = countryModel.country
        view.tvTotalCases.text = countryModel.totalCases
        view.tvTotalActiveCases.text = countryModel.activeCases
        view.tvTotalDeath.text = countryModel.totalDeaths
        view.tvTotalRecovered.text = countryModel.totalRecovered
        view.tvTotalNewCases.text = countryModel.newCases
        view.tvTotalNewDeath.text = countryModel.newDeaths
        view.tvTotalCriticalCases.text = countryModel.seriousCritical
    }
}