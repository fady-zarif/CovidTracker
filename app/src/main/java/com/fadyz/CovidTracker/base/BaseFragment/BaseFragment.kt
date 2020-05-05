package com.fadyz.CovidTracker.base.BaseFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.fadyz.CovidTracker.R
import com.fadyz.CovidTracker.base.BaseActivity.BaseActivity
import com.fadyz.CovidTracker.base.BaseViewModel.BaseViewModel
import kotlinx.android.synthetic.main.base_view.*
import kotlinx.android.synthetic.main.base_view.view.activtiesContainer

abstract class BaseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.base_view, container, false)
        LayoutInflater.from(context).inflate(getChildFragment(), view.activtiesContainer)
        return view
    }

    abstract fun getChildFragment(): Int

    fun observeBaseViewModel(viewModel: BaseViewModel) {
        viewModel.showErrorLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it.errorMsgString, Toast.LENGTH_LONG).show()
        })
        viewModel.showLoadingViewLiveData.observe(viewLifecycleOwner, Observer {
            if (it) showProgressView() else hideProgressView()
        })
    }

    private fun showProgressView() {
        activtiesContainer.visibility = View.GONE;
        ScreenProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressView() {
        activtiesContainer.visibility = View.VISIBLE;
        ScreenProgressBar.visibility = View.GONE

    }

    // any Activity will inheret from baseActivity
    private fun showProgressDialog() {
        (activity as BaseActivity).showProgressDialog()
    }

    private fun dismissProgressDialog() {
        (activity as BaseActivity).dismissProgressDialog()
    }


}