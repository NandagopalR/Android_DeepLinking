package com.nanda.deeplinking.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView
import com.nanda.deeplinking.R
import com.nanda.deeplinking.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity() {

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    private var clickableLinkSpan: ClickableSpan = object : ClickableSpan() {
        override fun onClick(widget: View) {
            openBrowser()
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.nanda.deeplinking.R.layout.activity_home)
        setSupportActionBar(toolbar)
        setToolbarTitle(resources.getString(com.nanda.deeplinking.R.string.toolbar_name))

        tv_browser_hint.setText(
            getSpannableString(getString(com.nanda.deeplinking.R.string.hint_browser), getString(R.string.domain_link)),
            TextView.BufferType.SPANNABLE
        )
        tv_browser_hint.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private fun getSpannableString(title: String, link: String): SpannableStringBuilder {
        val spannableStringBuilder = SpannableStringBuilder()
        val titleSpan = SpannableString(title)
        val linkSpan = SpannableString(link)

        val titleColorSpan = ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimary))
        val linkColorSpan = ForegroundColorSpan(ContextCompat.getColor(this, R.color.web_url))

        titleSpan.setSpan(StyleSpan(Typeface.BOLD), 43, 58, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        titleSpan.setSpan(titleColorSpan, 43, 58, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        linkSpan.setSpan(linkColorSpan, 0, link.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        linkSpan.setSpan(clickableLinkSpan, 0, link.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        spannableStringBuilder.append(titleSpan)
        spannableStringBuilder.append(" ")
        spannableStringBuilder.append(linkSpan)
        return spannableStringBuilder
    }

    private fun openBrowser() {
        val browserIntent = Intent(Intent.ACTION_VIEW)
        browserIntent.setData(Uri.parse(getString(R.string.domain_link)));
        browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(browserIntent)
    }

}
