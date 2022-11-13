
package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import java.lang.reflect.Array.set

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel :MainActivityModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =ViewModelProvider(this ).get(MainActivityModel::class.java)
        val textView = findViewById<TextView>(R.id.tvCount)
        val button = findViewById<Button>(R.id.button)
        viewModel.count.observe(this, Observer {


            textView.text =it.toString()
        })

        button.setOnClickListener {
            //++count
            //textview.text =viewModel.count.toString()
            viewModel.updateCount()
            //textView.text = viewModel.count.toString()
        }
    }
}

