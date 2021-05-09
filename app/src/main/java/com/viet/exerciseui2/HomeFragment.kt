package com.viet.exerciseui2

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

    var arrayListHome: ArrayList<Home> = ArrayList()
    lateinit var adapterHome : HomeAdapter
    var indicator_active: Drawable? = null
    var indicator_inactive: Drawable? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
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
        var view : View = inflater.inflate(R.layout.fragment_home, container, false)
        view.recyclerViewShow.layoutManager = LinearLayoutManager(this.context)
        view.recyclerViewShow.setHasFixedSize(true)
        //view.recyclerViewShow.itemAnimator = DefaultItemAnimator()
        view.recyclerViewShow.addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager(this.context).orientation))
        adapterHome = HomeAdapter(arrayListHome)
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(view.recyclerViewShow)
        view.recyclerViewShow.adapter = adapterHome
        view.btnLoadmore.setOnClickListener {
            addData()
            adapterHome.notifyDataSetChanged()
        }
        indicator_active = this.context?.let { ContextCompat.getDrawable(it, R.drawable.bg_fab_active) }
        indicator_inactive = this.context?.let { ContextCompat.getDrawable(it, R.drawable.bg_fab) }

        return view
    }
    fun addData(){
        for (i in 0 until 10){
            arrayListHome.add(Home("DAX " + i, "LONDON " + i,
                "20.047," + i, "10:44:" + i, "+203 (+1," + i + "%)"))
        }
    }
}