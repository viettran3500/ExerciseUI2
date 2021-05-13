package com.viet.exerciseui2.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.viet.exerciseui2.model.Account
import com.viet.exerciseui2.R
import com.viet.exerciseui2.utils.addAccount
import kotlinx.android.synthetic.main.activity_sign_up.btnForgotPassword
import kotlinx.android.synthetic.main.activity_sign_up.btnLogin
import kotlinx.android.synthetic.main.activity_sign_up.btnSignUp
import kotlinx.android.synthetic.main.activity_sign_up.editTextEmail
import kotlinx.android.synthetic.main.activity_sign_up.editTextPassword

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btnForgotPassword.setOnClickListener {
            val intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)
        }

        btnSignUp.setOnClickListener {
            if (editTextEmail.text.toString().isEmpty() || editTextPassword.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                addAccount(Account(editTextEmail.text.toString(), editTextPassword.text.toString()))
                val intent = Intent(this, EmailActivity::class.java)
                intent.putExtra("email", editTextEmail.text.toString())
                intent.putExtra("password", editTextPassword.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
