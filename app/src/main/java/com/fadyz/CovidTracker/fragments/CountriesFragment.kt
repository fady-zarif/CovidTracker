package com.fadyz.CovidTracker.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.fadyz.CovidTracker.R
import com.fadyz.CovidTracker.adapters.CountriesRecyclerAdapter
import com.fadyz.CovidTracker.base.BaseFragment.BaseFragment
import com.fadyz.CovidTracker.viewModels.MainActivityViewModel
import com.fadyz.CovidTracker.views.BottomSheetView
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import kotlinx.android.synthetic.main.fragment_countries.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel
import java.util.concurrent.TimeUnit


/**
 * A simple [Fragment] subclass.
 */
const val FIRST_ELEMENT_POSITION = 0

class CountriesFragment() : BaseFragment() {
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
        initSearchView()

        mainActivityViewModel.getCountriesLiveData().observe(viewLifecycleOwner, Observer {
            countriesRecyclerAdapter.updateCurrentList(it)
            rvCountries.smoothScrollToPosition(FIRST_ELEMENT_POSITION)
            edit_text_countries_search.setText("")
            hideKeyboardFrom(requireContext(), edit_text_countries_search)
        })
    }


    private fun initSearchView() {
        edit_text_countries_search.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                if (!s?.toString().equals(""))
                    Observable.just(s).delay(2, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread())
                            .debounce(1, TimeUnit.SECONDS)
                            .subscribe {
                                hideKeyboardFrom(requireContext(), edit_text_countries_search)
                       }
            }


            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                countriesRecyclerAdapter.filter.filter(s)
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
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

    fun hideKeyboardFrom(context: Context, view: View) {
        val imm: InputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
