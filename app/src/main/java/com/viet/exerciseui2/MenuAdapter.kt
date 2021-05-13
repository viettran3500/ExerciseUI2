package com.viet.exerciseui2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rcv_one.view.*
import kotlinx.android.synthetic.main.item_rcv_two.view.*

class MenuAdapter
    (
    private val listOne: MutableList<ListMenuOne>,
    private val listTwo: MutableList<ListMenuTwo>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        return when (viewType) {
            ViewType.TYPE_ONE.type -> {
                val view = inflater.inflate(R.layout.item_rcv_one, parent, false)
                TypeOneViewHodel(view)
            }
            else -> {
                val view = inflater.inflate(R.layout.item_rcv_two, parent, false)
                TypeTwoViewHodel(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.apply {
            when (holder) {
                is TypeOneViewHodel -> holder.bind(listOne[position])
                is TypeTwoViewHodel -> holder.bind(listTwo[position - listOne.size])
            }
        }
    }

    override fun getItemCount(): Int {
        return listOne.size + listTwo.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            in 0 until listOne.count() -> ViewType.TYPE_ONE.type
            else -> ViewType.TYPE_TWO.type
        }
    }

    inner class TypeOneViewHodel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemOne: ListMenuOne) {
            with(itemView) {
                img_item_menu_one_1.setImageResource(itemOne.img[0])
                tv_item_menu_one_1.text = itemOne.text[0]
                img_item_menu_one_2.setImageResource(itemOne.img[1])
                tv_item_menu_one_2.text = itemOne.text[1]
                img_item_menu_one_3.setImageResource(itemOne.img[2])
                tv_item_menu_one_3.text = itemOne.text[2]
                img_item_menu_one_4.setImageResource(itemOne.img[3])
                tv_item_menu_one_4.text = itemOne.text[3]
            }

        }

    }

    inner class TypeTwoViewHodel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemTwo: ListMenuTwo) {
            with(itemView) {
                tv_title_item_menu.text = itemTwo.title
                img_item_menu_two_1.setImageResource(itemTwo.img[0])
                img_item_menu_two_2.setImageResource(itemTwo.img[1])
                img_item_menu_two_3.setImageResource(itemTwo.img[2])
                img_item_menu_two_4.setImageResource(itemTwo.img[3])
                tv_item_menu_two_1.text = itemTwo.text[0]
                tv_item_menu_two_1.text = itemTwo.text[1]
                tv_item_menu_two_1.text = itemTwo.text[2]
                tv_item_menu_two_1.text = itemTwo.text[3]
            }
        }

    }

    enum class ViewType(val type: Int) {
        TYPE_ONE(0),
        TYPE_TWO(1)
    }
}
