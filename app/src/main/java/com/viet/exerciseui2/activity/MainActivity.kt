package com.viet.exerciseui2.activity

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.viet.exerciseui2.fragment.NewsArticleFragment
import com.viet.exerciseui2.utils.OnFragmentManager
import com.viet.exerciseui2.R
import com.viet.exerciseui2.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), OnFragmentManager {

    var indicator_active: Drawable? = null
    var indicator_inactive: Drawable? = null
    var stack = Stack<Int>()
    lateinit var viewPagerAdapter: ViewPagerAdapter
    var fragmentManager: FragmentManager = supportFragmentManager
    lateinit var dialog: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialog = AlertDialog.Builder(this)

        stack.push(0)
        indicator_active = ContextCompat.getDrawable(this, R.drawable.bg_item_bottom_navigation)
        indicator_inactive =
            ContextCompat.getDrawable(this, R.drawable.bg_item_bottom_navigation_notcheck)

        viewPagerAdapter =
            ViewPagerAdapter(
                supportFragmentManager,
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
            )
        viewPager.adapter = viewPagerAdapter
        btnHome.setOnClickListener {
            viewPager.currentItem = 0
            selectionBottomNavigation(0)
        }
        btnCoin.setOnClickListener {
            viewPager.currentItem = 1
            selectionBottomNavigation(1)
        }
        btnNews.setOnClickListener {
            viewPager.currentItem = 2
            selectionBottomNavigation(2)
        }
        btnMenu.setOnClickListener {
            viewPager.currentItem = 3
            selectionBottomNavigation(3)
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        selectionBottomNavigation(0)
                        if (stack.search(0) == -1)
                            stack.push(0)
                        else {
                            stack = filterStack(stack, stack.search(0))
                            stack.push(0)
                        }
                    }
                    1 -> {
                        selectionBottomNavigation(1)
                        if (stack.search(1) == -1)
                            stack.push(1)
                        else {
                            stack = filterStack(stack, stack.search(1))
                            stack.push(1)
                        }
                    }
                    2 -> {
                        selectionBottomNavigation(2)
                        if (stack.search(2) == -1)
                            stack.push(2)
                        else {
                            stack = filterStack(stack, stack.search(2))
                            stack.push(2)
                        }
                    }
                    3 -> {
                        selectionBottomNavigation(3)
                        if (stack.search(3) == -1)
                            stack.push(3)
                        else {
                            stack = filterStack(stack, stack.search(3))
                            stack.push(3)
                        }
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

    }

    fun selectionBottomNavigation(i: Int) {
        frame_new_article.visibility = View.INVISIBLE
        when (i) {
            0 -> {
                imgHome.setImageResource(R.drawable.icons_8_increase)
                imgHome.background = indicator_active
                imgCoin.setImageResource(R.drawable.icons_8_chart)
                imgCoin.background = indicator_inactive
                imgNews.setImageResource(R.drawable.icons_8_news)
                imgNews.background = indicator_inactive
                imgMenu.setImageResource(R.drawable.icons_8_customer)
                imgMenu.background = indicator_inactive
            }
            1 -> {
                imgHome.setImageResource(R.drawable.icons_8_increase_2)
                imgHome.background = indicator_inactive
                imgCoin.setImageResource(R.drawable.icons_8_chart_2)
                imgCoin.background = indicator_active
                imgNews.setImageResource(R.drawable.icons_8_news)
                imgNews.background = indicator_inactive
                imgMenu.setImageResource(R.drawable.icons_8_customer)
                imgMenu.background = indicator_inactive
            }
            2 -> {
                imgHome.setImageResource(R.drawable.icons_8_increase_2)
                imgHome.background = indicator_inactive
                imgCoin.setImageResource(R.drawable.icons_8_chart)
                imgCoin.background = indicator_inactive
                imgNews.setImageResource(R.drawable.icons_8_news)
                imgNews.background = indicator_active
                imgMenu.setImageResource(R.drawable.icons_8_customer)
                imgMenu.background = indicator_inactive
            }
            3 -> {
                imgHome.setImageResource(R.drawable.icons_8_increase_2)
                imgHome.background = indicator_inactive
                imgCoin.setImageResource(R.drawable.icons_8_chart)
                imgCoin.background = indicator_inactive
                imgNews.setImageResource(R.drawable.icons_8_news)
                imgNews.background = indicator_inactive
                imgMenu.setImageResource(R.drawable.icons_8_customer)
                imgMenu.background = indicator_active
            }
        }
    }


    override fun onBackPressed() {
        if (frame_new_article.visibility == View.VISIBLE) {
            frame_new_article.visibility = View.INVISIBLE
        } else if (stack.pop() != 0) {
            var i = stack.pop()
            viewPager.currentItem = i
        } else {
            dialog.setTitle("Notification")
            dialog.setMessage("Do you agree to exit the program?")
            dialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                super.onBackPressed()
            })
            dialog.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                stack.push(0)
            })
            dialog.show()
        }
    }

    fun filterStack(s: Stack<Int>, p: Int): Stack<Int> {
        var stack2: Stack<Int> = Stack<Int>()
        for (i in 0 until s.size) {
            if (i == p - 1) s.pop()
            else {
                stack2.push(s.pop())
            }
        }
        for (i in 0 until stack2.size) {
            s.push(stack2.pop())
        }
        return s
    }

    override fun onDataSelected(text: String) {
        var bundle = Bundle()
        var newsArticleFragment = NewsArticleFragment()
        bundle.putString("data", text)
        newsArticleFragment.arguments = bundle
        var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        frame_new_article.visibility = View.VISIBLE
        fragmentTransaction.replace(R.id.frame_new_article, newsArticleFragment)
        fragmentTransaction.commit()
    }
}
