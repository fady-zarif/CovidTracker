package com.fadyz.CovidTracker.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.fadyz.CovidTracker.R
import com.fadyz.CovidTracker.adapters.CountriesRecyclerAdapter
import com.fadyz.CovidTracker.base.BaseFragment.BaseFragment
import com.fadyz.CovidTracker.viewModels.MainActivityViewModel
import com.fadyz.CovidTracker.views.BottomSheetView
import kotlinx.android.synthetic.main.fragment_countries.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 */
const val FIRST_ELEMENT_POSITION = 0

class CountriesFragment : BaseFragment() {
    private val countriesRecyclerAdapter: CountriesRecyclerAdapter by inject()
    private val mainActivityViewModel: MainActivityViewModel by sharedViewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun getChildFragment(): Int {
        return R.layout.fragment_countries
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel.getServerData()
        initAdapter()
        observeBaseViewModel(mainActivityViewModel)

        mainActivityViewModel.getCountriesLiveData().observe(viewLifecycleOwner, Observer {
            countriesRecyclerAdapter.updateCurrentList(it)
            rvCountries.smoothScrollToPosition(FIRST_ELEMENT_POSITION)
        })
    }

    private fun initAdapter() {
        rvCountries.layoutManager = GridLayoutManager(context, 1)
        rvCountries.adapter = countriesRecyclerAdapter
        countriesRecyclerAdapter.onItemClick = {
            val bottomSheetView = BottomSheetView(it)
            bottomSheetView.show(childFragmentManager, this::class.java.simpleName)
        }
    }
}
