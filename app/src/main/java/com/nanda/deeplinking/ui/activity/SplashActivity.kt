package com.nanda.deeplinking.ui.activity

import android.os.Bundle
import android.os.Handler
import com.nanda.deeplinking.R
import com.nanda.deeplinking.ui.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            navigateToHomeActivity()
        }, 1000)
    }

    private fun navigateToHomeActivity() {
        startActivity(HomeActivity.getCallingIntent(this))
        finish()
    }

}