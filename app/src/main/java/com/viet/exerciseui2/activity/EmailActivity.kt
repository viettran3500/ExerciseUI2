package com.viet.exerciseui2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.viet.exerciseui2.R
import com.viet.exerciseui2.utils.updatePassword
import kotlinx.android.synthetic.main.activity_email.*

class EmailActivity : AppCompatActivity() {

    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        countDownTimer = object : CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                textCountdown.text = "Wait ${p0/1000} seconds before sending it"
            }

            override fun onFinish() {
                updatePassword()
                startActivity(Intent(this@EmailActivity, ConfirmActivity::class.java))
                finish()
            }

        }

        btnResendEmail.setOnClickListener {
            countDownTimer.start()
        }

    }
}
