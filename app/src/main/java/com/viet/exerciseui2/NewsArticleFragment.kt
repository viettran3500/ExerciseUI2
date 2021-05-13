package com.viet.exerciseui2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_news_article.*
import kotlinx.android.synthetic.main.fragment_news_article.view.*

class NewsArticleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_news_article, container, false)
        var bundle: Bundle? = arguments
        var title = ""
        if (bundle != null) {
            title = bundle.getString("data").toString()
            view.tvtitle.text = title
        }
        view.tvEditrial.setOnClickListener {
            view.tvEditrial.setBackgroundResource(R.drawable.bg_textview)
            view.tvCrypto.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvRaw.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvEconomics.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
        }
        view.tvCrypto.setOnClickListener {
            view.tvCrypto.setBackgroundResource(R.drawable.bg_textview)
            view.tvEditrial.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvRaw.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvEconomics.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
        }
        view.tvRaw.setOnClickListener {
            view.tvRaw.setBackgroundResource(R.drawable.bg_textview)
            view.tvCrypto.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvEditrial.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvEconomics.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
        }
        view.tvEconomics.setOnClickListener {
            view.tvEconomics.setBackgroundResource(R.drawable.bg_textview)
            view.tvCrypto.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvRaw.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvEditrial.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
        }
        return view
    }
}