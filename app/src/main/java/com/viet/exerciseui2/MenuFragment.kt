package com.viet.exerciseui2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : Fragment() {
    var typeOneList: MutableList<ListMenuOne> = mutableListOf()
    var typeTwoList: MutableList<ListMenuTwo> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_menu, container, false)
        addTypeList1()
        addTypeList2()
        view.rcv.layoutManager = LinearLayoutManager(this.context)
        view.rcv.setHasFixedSize(true)
        view.rcv.addItemDecoration(
            DividerItemDecoration(
                this.context,
                LinearLayoutManager(this.context).orientation
            )
        )
        view.rcv.adapter = MenuAdapter(typeOneList, typeTwoList)
        return view
    }


    fun addTypeList1() {
        var listImg: ArrayList<Int> = ArrayList()
        listImg.add(R.drawable.icons_8_alarm)
        listImg.add(R.drawable.icons_8_left_and_right_arrows)
        listImg.add(R.drawable.icons_8_pin)
        listImg.add(R.drawable.icons_8_no_entry)
        var listText: ArrayList<String> = ArrayList()
        listText.add("Alerts")
        listText.add("Predictions")
        listText.add("Saved elements")
        listText.add("Remove Ads")
        typeOneList?.add(ListMenuOne(listImg, listText))
    }

    fun addTypeList2() {
        var listImg: ArrayList<Int> = ArrayList()
        listImg.add(R.drawable.icons_8_profit_2)
        listImg.add(R.drawable.icons_8_swap)
        listImg.add(R.drawable.icons_8_video_call)
        listImg.add(R.drawable.icons_8_rent)
        var listText: ArrayList<String> = ArrayList()
        listText.add("Select Stocks")
        listText.add("Currency Exchange")
        listText.add("Webinar")
        listText.add("Best Broker")
        typeTwoList?.add(ListMenuTwo("Tools", listImg, listText))
        typeTwoList?.add(ListMenuTwo("Markets", listImg, listText))
    }
}