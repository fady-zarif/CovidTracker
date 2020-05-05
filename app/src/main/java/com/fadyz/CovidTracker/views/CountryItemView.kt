package com.fadyz.CovidTracker.views

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.fadyz.CovidTracker.Models.CountryModel
import com.fadyz.CovidTracker.R
import com.fadyz.CovidTracker.base.loadImage
import kotlinx.android.synthetic.main.country_item_view.view.*

class CountryItemView(context: Context) : LinearLayout(context) {

    init {
        initView()
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.country_item_view, this)

    }

     fun setCountryView(country: CountryModel) {

        loadImage(country.flag,imgFlag).into(imgFlag)
//        Picasso.get().load(country.flag)
//                .fit().into(imgFlag)

    }

}