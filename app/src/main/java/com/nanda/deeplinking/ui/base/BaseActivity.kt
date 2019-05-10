package com.nanda.deeplinking.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setToolbarTitle(title: String) {
        supportActionBar!!.title = title
    }

}