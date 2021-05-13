package com.viet.exerciseui2

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    var indicator_active1: Drawable? = null
    var indicator_inactive1: Drawable? = null

    var arrayListHome: ArrayList<Home> = ArrayList()
    lateinit var adapterHome: HomeAdapter

    var indicator_active: Drawable? = null
    var indicator_inactive: Drawable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    TODO("Not yet implemented")
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    arrayListHome.removeAt(viewHolder.adapterPosition)
                    adapterHome.notifyDataSetChanged()
                }

            }
        addData()
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)

        view.recyclerViewShow.layoutManager = LinearLayoutManager(this.context)
        view.recyclerViewShow.setHasFixedSize(true)
        view.recyclerViewShow.addItemDecoration(
            DividerItemDecoration(
                this.context,
                LinearLayoutManager(this.context).orientation
            )
        )
        adapterHome = HomeAdapter(arrayListHome)
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(view.recyclerViewShow)
        view.recyclerViewShow.adapter = adapterHome
        view.btnLoadmore.setOnClickListener {
            for (i in arrayListHome.size until arrayListHome.size + 10) {
                arrayListHome.add(
                    Home(
                        "DAX " + i, "LONDON " + i,
                        "20.047," + i, "10:44:" + i, "+203 (+1," + i + "%)"
                    )
                )
            }
            adapterHome.notifyDataSetChanged()
        }

        indicator_active = ContextCompat.getDrawable(this.context!!, R.drawable.bg_fab_active)
        indicator_inactive = ContextCompat.getDrawable(this.context!!, R.drawable.bg_fab)
        view.imgnotification.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {
                if (motionEvent != null) {
                    if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                        view.imgnotification.background = indicator_active
                    }
                    if (motionEvent.action == MotionEvent.ACTION_UP) {
                        view.imgnotification.background = indicator_inactive
                    }
                }
                return true
            }
        })

        indicator_active1 = ContextCompat.getDrawable(this.context!!, R.drawable.bg_button_loadmore)
        indicator_inactive1 =
            ContextCompat.getDrawable(this.context!!, R.drawable.bg_item_bottom_navigation_notcheck)
        view.tvIndex.setOnClickListener {
            view.tvIndex.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvShares.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvCurrencise.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvFutures.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvCrypto.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvIndex.background = indicator_active1
            view.tvShares.background = indicator_inactive1
            view.tvCurrencise.background = indicator_inactive1
            view.tvFutures.background = indicator_inactive1
            view.tvCrypto.background = indicator_inactive1
        }
        view.tvShares.setOnClickListener {
            view.tvIndex.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvShares.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvCurrencise.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvFutures.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvCrypto.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvIndex.background = indicator_inactive1
            view.tvShares.background = indicator_active1
            view.tvCurrencise.background = indicator_inactive1
            view.tvFutures.background = indicator_inactive1
            view.tvCrypto.background = indicator_inactive1
        }
        view.tvCurrencise.setOnClickListener {
            view.tvIndex.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvShares.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvCurrencise.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvFutures.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvCrypto.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvIndex.background = indicator_inactive1
            view.tvShares.background = indicator_inactive1
            view.tvCurrencise.background = indicator_active1
            view.tvFutures.background = indicator_inactive1
            view.tvCrypto.background = indicator_inactive1
        }
        view.tvFutures.setOnClickListener {
            view.tvIndex.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvShares.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvCurrencise.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvFutures.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvCrypto.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvIndex.background = indicator_inactive1
            view.tvShares.background = indicator_inactive1
            view.tvCurrencise.background = indicator_inactive1
            view.tvFutures.background = indicator_active1
            view.tvCrypto.background = indicator_inactive1
        }
        view.tvCrypto.setOnClickListener {
            view.tvIndex.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvShares.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvCurrencise.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvFutures.setTextColor(Color.argb(255, 0, 0, 0))
            view.tvCrypto.setTextColor(Color.argb(255, 255, 255, 255))
            view.tvIndex.background = indicator_inactive1
            view.tvShares.background = indicator_inactive1
            view.tvCurrencise.background = indicator_inactive1
            view.tvFutures.background = indicator_inactive1
            view.tvCrypto.background = indicator_active1
        }
        return view
    }

    fun addData() {
        for (i in 0 until 10) {
            arrayListHome.add(
                Home(
                    "DAX " + i, "LONDON " + i,
                    "20.047," + i, "10:44:" + i, "+203 (+1," + i + "%)"
                )
            )
        }
    }
}