package com.example.varaxinar_02_03

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP2", Context.MODE_PRIVATE)
        val button = findViewById<Button>(R.id.appCompatButton)
        val email = findViewById<EditText>(R.id.editText)
        val password = findViewById<EditText>(R.id.editText2)

        button.setOnClickListener {
            val emailText = email.text.toString()
            val passText = password.text.toString()

            if (emailText.isEmpty() || passText.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Поля не должны быть пустыми")
                    .setPositiveButton("ОК", null)
                    .show()
                return@setOnClickListener
            }

            val savedEmail = sharedPreferences.getString("email", null)
            val savedPass = sharedPreferences.getString("pass", null)

            if (savedEmail == null) {
                sharedPreferences.edit().apply {
                    putString("email", emailText)
                    putString("pass", passText)
                    apply()
                }

                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()
            } else {
                if (emailText == savedEmail && passText == savedPass) {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Неверный логин или пароль")
                        .setPositiveButton("ОК", null)
                        .show()
                }
            }
        }
    }
}
