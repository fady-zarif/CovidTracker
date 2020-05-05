package com.fadyz.CovidTracker.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fadyz.CovidTracker.views.CountryItemView
import com.fadyz.CovidTracker.Models.CountryModel
import org.koin.dsl.module

class CountriesRecyclerAdapter : RecyclerView.Adapter<CountriesRecyclerAdapter.CountriesViewHolder>() {
    private val countryList = ArrayList<CountryModel>()
    var onItemClick: ((CountryModel) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(CountryItemView(parent.context))
    }

    override fun getItemCount(): Int = countryList.size


    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.countryItemView.setCountryView(countryList[position])
        holder.countryItemView.setOnClickListener {
            onItemClick?.invoke(countryList[position])
        }
    }


    fun updateCurrentList(list: ArrayList<CountryModel>) {
        if (list[0].country == "World")
            countryList.clear()
        countryList.addAll(list.filter { it.country != "World" })
        this.notifyDataSetChanged()
    }


    class CountriesViewHolder(val countryItemView: CountryItemView) : RecyclerView.ViewHolder(countryItemView)

}


val adapterModule = module {
    single { CountriesRecyclerAdapter() }
}
