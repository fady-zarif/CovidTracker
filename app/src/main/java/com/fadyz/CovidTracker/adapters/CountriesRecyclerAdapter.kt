package com.fadyz.CovidTracker.adapters

import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.fadyz.CovidTracker.views.CountryItemView
import com.fadyz.CovidTracker.Models.CountryModel
import org.koin.dsl.module

const val FIRST_LIST_ELEMENT = "World"

class CountriesRecyclerAdapter : RecyclerView.Adapter<CountriesRecyclerAdapter.CountriesViewHolder>(), Filterable {
    private val countryList = mutableListOf<CountryModel>()
    private val countryListFull = mutableListOf<CountryModel>()
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
        if (list[0].country == FIRST_LIST_ELEMENT)
            countryList.clear()
        countryList.addAll(list.filter { it.country != FIRST_LIST_ELEMENT })
        countryListFull.addAll(list.filter { it.country != FIRST_LIST_ELEMENT })
        this.notifyDataSetChanged()
    }


    class CountriesViewHolder(val countryItemView: CountryItemView) : RecyclerView.ViewHolder(countryItemView)

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var list = mutableListOf<CountryModel>()
                if (constraint == null || constraint.isEmpty())
                    list = countryListFull
                else {
                    var searchWord = constraint.toString().toLowerCase()
                    for (cun in countryListFull) {
                        if (cun.country.toLowerCase().startsWith(searchWord))
                            list.add(cun);
                    }
                }


                var listResults = FilterResults()
                listResults.values = list
                return listResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                countryList.clear()
                countryList.addAll(results?.values as Collection<CountryModel>)
                notifyDataSetChanged()
            }

        }
    }

}


val adapterModule = module {
    single { CountriesRecyclerAdapter() }
}
