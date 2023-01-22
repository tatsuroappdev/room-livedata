package com.tatsuro.app.roomandlivedata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel
            = ViewModelProvider(this)[MainViewModel::class.java]

        val button = findViewById<Button>(R.id.insertButton)
        button.setOnClickListener {
            viewModel.insertUser()
        }

        viewModel.users.observe(this) {
            val textView = findViewById<TextView>(R.id.textView)
            textView.text = it.joinToString("\n")
        }
    }
}
