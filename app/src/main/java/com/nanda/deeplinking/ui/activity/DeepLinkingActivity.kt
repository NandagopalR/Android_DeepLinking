package com.nanda.deeplinking.ui.activity

import android.os.Bundle
import com.nanda.deeplinking.R
import com.nanda.deeplinking.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_deeplinking.*

class DeepLinkingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplinking)
        setSupportActionBar(toolbar)
        setToolbarTitle("Deep Linking")

        val data = intent.data
        val action = intent.action

        if (data != null) {
            tv_deeplink_data.text = data.toString()
        }
    }

}