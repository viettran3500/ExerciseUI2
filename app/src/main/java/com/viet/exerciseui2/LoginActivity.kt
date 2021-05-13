package com.viet.exerciseui2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_SING_UP)
        }

        btnForgotPassword.setOnClickListener {
            val intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            if (editTextEmail.text.toString().isEmpty() || editTextPassword.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT)
                    .show()
            } else if (!checkAccount(
                    Account(
                        editTextEmail.text.toString(),
                        editTextPassword.text.toString()
                    )
                )
            ) {
                Toast.makeText(this, "Email or password is incorrect", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_SING_UP) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                editTextEmail.setText(data.getStringExtra("email"))
                editTextPassword.setText(data.getStringExtra("password"))
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
