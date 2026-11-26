package com.example.varaxinar_02_03

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val name = intent.getStringExtra("name")
        val message = intent.getStringExtra("message")
        val imageResId = intent.getIntExtra("image", R.drawable.first)

        findViewById<ImageView>(R.id.image).setImageResource(imageResId)
        findViewById<TextView>(R.id.naame).text = name
        findViewById<TextView>(R.id.text2).text = message

        findViewById<View>(R.id.appCompatButton2).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}
