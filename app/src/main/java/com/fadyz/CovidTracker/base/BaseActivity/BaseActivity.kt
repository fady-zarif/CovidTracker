package com.fadyz.CovidTracker.base.BaseActivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.fadyz.CovidTracker.base.ProgressDialog.DefaultProgressDialog

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    private var dialog: DefaultProgressDialog? = null


    fun showProgressDialog() {
        getProgressDialog().showProgressDialog()
    }

    fun dismissProgressDialog() {
        getProgressDialog().dismissProgressDialog()
    }


    private fun getProgressDialog(): DefaultProgressDialog {
        if (dialog == null)
            dialog = DefaultProgressDialog(this)
        return dialog as DefaultProgressDialog
    }
}