package com.fadyz.CovidTracker.base.ProgressDialog

import android.app.Activity
import android.app.AlertDialog
import com.fadyz.CovidTracker.R

class DefaultProgressDialog(activity: Activity) : IProgressDialog {
    private var progressDefaultDialog: AlertDialog = AlertDialog.Builder(activity).setView(R.layout.loading_layout).setCancelable(false).create()

    override fun showProgressDialog() {
        progressDefaultDialog.show()
    }

    override fun dismissProgressDialog() {
        progressDefaultDialog.dismiss()
    }

}