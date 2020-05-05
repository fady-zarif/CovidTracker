package com.fadyz.CovidTracker.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.fadyz.CovidTracker.R
import com.fadyz.CovidTracker.base.BaseFragment.BaseFragment
import com.fadyz.CovidTracker.viewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_analytics.*

import org.koin.android.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 */
class AnalyticsFragment : BaseFragment() {
    val mainActivityViewModel: MainActivityViewModel by sharedViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun getChildFragment(): Int {
        return R.layout.fragment_analytics
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel.getGeneralStatus()
        observeBaseViewModel(mainActivityViewModel)

//        progress_bar.visibility = View.VISIBLE
        mainActivityViewModel.getStatiscsLiveData().observe(viewLifecycleOwner, Observer {
//            progress_bar.visibility = View.GONE
            tvTotalConfirmed.text = it.totalCases
            tvTotalRecovered.text= it.recoveryCases
            tvTotalDeath.text=it.deathCases
        })

    }


}
