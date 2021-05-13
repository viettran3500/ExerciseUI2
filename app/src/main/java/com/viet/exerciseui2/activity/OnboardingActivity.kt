package com.viet.exerciseui2.activity

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.viet.exerciseui2.fragment.Onboarding1
import com.viet.exerciseui2.fragment.Onboarding2
import com.viet.exerciseui2.fragment.Onboarding3
import com.viet.exerciseui2.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    var index = 1
    var onboarding1: Onboarding1 = Onboarding1()
    var onboarding2: Onboarding2 = Onboarding2()
    var onboarding3: Onboarding3 = Onboarding3()
    var indicator_active: Drawable? = null
    var indicator_inactive: Drawable? = null
    var fragmentManager: FragmentManager = supportFragmentManager
    val PREFS_NAME = "MyPrefsFile"
    lateinit var settings: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settings = getSharedPreferences(PREFS_NAME, 0)
        if (!settings.getBoolean("my_first_time", true)) {
            launchHomeScreen()
        } else {
        }
        setContentView(R.layout.activity_onboarding)

        indicator_active = ContextCompat.getDrawable(this, R.drawable.bg_indicator_active)
        indicator_inactive = ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive)

        var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame, onboarding1)
        fragmentTransaction.commit()

        btnNext.setOnClickListener {
            when (index) {
                1 -> {
                    indicator1.background = indicator_inactive
                    indicator2.background = indicator_active
                    btnBack.visibility = View.VISIBLE
                    var fragmentTransaction: FragmentTransaction =
                        fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.frame, onboarding2)
                    fragmentTransaction.commit()
                    index++
                }
                2 -> {
                    btnNext.setText("START")
                    indicator2.background = indicator_inactive
                    indicator3.background = indicator_active
                    btnBack.visibility = View.VISIBLE
                    var fragmentTransaction: FragmentTransaction =
                        fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.frame, onboarding3)
                    fragmentTransaction.commit()
                    index++
                }
                3 -> {
                    launchHomeScreen()
                }
            }
        }
        btnBack.setOnClickListener {
            when (index) {
                3 -> {
                    btnNext.setText("NEXT")
                    indicator3.background = indicator_inactive
                    indicator2.background = indicator_active
                    var fragmentTransaction: FragmentTransaction =
                        fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.frame, onboarding2)
                    fragmentTransaction.commit()
                    index--
                }
                2 -> {
                    indicator2.background = indicator_inactive
                    indicator1.background = indicator_active
                    btnBack.visibility = View.INVISIBLE
                    var fragmentTransaction: FragmentTransaction =
                        fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.frame, onboarding1)
                    fragmentTransaction.commit()
                    index--
                }
            }
        }

        btnSkip.setOnClickListener {
            launchHomeScreen()
        }
    }

    fun launchHomeScreen() {
        settings.edit().putBoolean("my_first_time", false).commit();
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        when (index) {
            1 -> {
                super.onBackPressed()
            }
            2 -> {
                indicator2.background = indicator_inactive
                indicator1.background = indicator_active
                btnBack.visibility = View.INVISIBLE
                var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frame, onboarding1)
                fragmentTransaction.commit()
                index--
            }
            3 -> {
                btnNext.setText("NEXT")
                indicator3.background = indicator_inactive
                indicator2.background = indicator_active
                var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frame, onboarding2)
                fragmentTransaction.commit()
                index--
            }
        }
    }
}
