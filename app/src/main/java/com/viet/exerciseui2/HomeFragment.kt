package com.viet.exerciseui2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    var arrayListHome: ArrayList<Home> = ArrayList()
    lateinit var adapterHome : HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addData()
        var view : View = inflater.inflate(R.layout.fragment_home, container, false)
        view.recyclerViewShow.layoutManager = LinearLayoutManager(this.context)
        view.recyclerViewShow.setHasFixedSize(true)
        //view.recyclerViewShow.itemAnimator = DefaultItemAnimator()
        view.recyclerViewShow.addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager(this.context).orientation))
        adapterHome = HomeAdapter(arrayListHome)
        view.recyclerViewShow.adapter = adapterHome
        view.btnLoadmore.setOnClickListener {
            addData()
            adapterHome.notifyDataSetChanged()
        }
        return view
    }

    fun addData(){
        for (i in 0 until 10){
            arrayListHome.add(Home("DAX " + i, "LONDON " + i,
                "20.047," + i, "10:44:" + i, "+203 (+1," + i + "%)"))
        }
    }
}