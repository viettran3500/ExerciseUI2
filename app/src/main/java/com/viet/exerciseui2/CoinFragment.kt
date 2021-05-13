package com.viet.exerciseui2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_coin.view.*

class CoinFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_coin, container, false)
        view.imgnotification.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {

                if (motionEvent != null) {
                    if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                        view.imgnotification.setBackgroundResource(R.drawable.bg_fab_active)
                    }
                    if (motionEvent.action == MotionEvent.ACTION_UP) {
                        view.imgnotification.setBackgroundResource(R.drawable.bg_fab)
                    }
                }
                return true
            }
        })
        view.tvGeneral.setOnClickListener {
            view.tvGeneral.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvTechnical.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvMarkets.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvCharts.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvGeneral.setBackgroundResource(R.drawable.bg_button_loadmore)
            view.tvTechnical.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvMarkets.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvCharts.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
        }
        view.tvTechnical.setOnClickListener {
            view.tvTechnical.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvGeneral.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvMarkets.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvCharts.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvTechnical.setBackgroundResource(R.drawable.bg_button_loadmore)
            view.tvGeneral.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvMarkets.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvCharts.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
        }
        view.tvMarkets.setOnClickListener {
            view.tvMarkets.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvTechnical.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvGeneral.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvCharts.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvMarkets.setBackgroundResource(R.drawable.bg_button_loadmore)
            view.tvTechnical.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvGeneral.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvCharts.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
        }
        view.tvCharts.setOnClickListener {
            view.tvCharts.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvTechnical.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvMarkets.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvGeneral.setTextColor(Color.argb(255, 34, 34, 34))
            view.tvCharts.setBackgroundResource(R.drawable.bg_button_loadmore)
            view.tvTechnical.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvMarkets.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
            view.tvGeneral.setBackgroundResource(R.drawable.bg_item_bottom_navigation_notcheck)
        }
        return view
    }
}