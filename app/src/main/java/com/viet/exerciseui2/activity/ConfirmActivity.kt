package com.viet.exerciseui2.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.viet.exerciseui2.R
import kotlinx.android.synthetic.main.activity_confirm.*

class ConfirmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
