package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView;
    private lateinit var addbtn: ImageView;
    private lateinit var rembtn: ImageView;
    private lateinit var resetbtn: ImageView;
    private lateinit var torndpagebtn: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        addbtn = findViewById(R.id.add)
        rembtn = findViewById(R.id.rem)
        resetbtn = findViewById(R.id.res)
        torndpagebtn = findViewById(R.id.btnToRndPage)

        addbtn.setOnClickListener { addPoint() }
        rembtn.setOnClickListener { remPoint() }
        resetbtn.setOnClickListener { resetPoint() }
        torndpagebtn.setOnClickListener { toRndPage() }

    }

    fun toRndPage() {
        val rndPageIntent = Intent(this, RandomNumberActivity::class.java)

        val countStr: String = textView.text.toString()
        val count: Int = Integer.parseInt(countStr)

        rndPageIntent.putExtra(RandomNumberActivity.RANDOM_TO, count)

        startActivity(rndPageIntent)
    }

    fun addPoint() {
        val countStr: String = textView.text.toString()

        var count: Int = Integer.parseInt(countStr)
        count++

        textView.text = count.toString()
    }

    fun remPoint() {
        val countStr: String = textView.text.toString()

        var count: Int = Integer.parseInt(countStr)
        count--

        if (count >= 0) {
            textView.text = count.toString()
        }
    }

    fun resetPoint() {
        textView.text = "0";
    }
}
