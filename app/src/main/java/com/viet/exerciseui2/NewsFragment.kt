package com.viet.exerciseui2

import android.content.Context
import android.graphics.Color
import android.net.sip.SipSession
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_news.view.*
import java.lang.RuntimeException

class NewsFragment : Fragment() {

    lateinit var listener : OnFragmentManager
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentManager ){
            listener  = context as OnFragmentManager
        } else {
            throw RuntimeException(context.toString() + " must implement onViewSelected");
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.fragment_news, container, false)
        view.layoutatlantia.setOnClickListener {
            listener.onDataSelected("ALANTIA")
        }
        view.layoutxiaomi.setOnClickListener {
            listener.onDataSelected("XIAOMI")
        }
        view.layoutapple.setOnClickListener {
            listener.onDataSelected("APPLE")
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