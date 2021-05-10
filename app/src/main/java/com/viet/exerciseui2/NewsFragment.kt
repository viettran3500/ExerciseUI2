package com.viet.exerciseui2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.fragment_news, container, false)
        var fragmentManager: FragmentManager? = getFragmentManager()
        var newsArticleFragment : NewsArticleFragment = NewsArticleFragment()
        var fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()

        view.layoutatlantia.setOnClickListener {
            view.tvtitle.text = "Atlantia News"
            fragmentTransaction.replace(R.id.fragment_article, newsArticleFragment)
            fragmentTransaction.commit()
        }
        view.layoutxiaomi.setOnClickListener {
            view.tvtitle.text = "Xiaomi News"
            fragmentTransaction.replace(R.id.fragment_article, newsArticleFragment)
            fragmentTransaction.commit()
        }
        view.layoutapple.setOnClickListener {
            view.tvtitle.text = "Apple News"
            fragmentTransaction.replace(R.id.fragment_article, newsArticleFragment)
            fragmentTransaction.commit()
        }
        return view
    }
}