package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class RandomNumberActivity : AppCompatActivity() {

    companion object {
        const val RANDOM_TO = "random_to"
    }

    private lateinit var textView: TextView;
    private lateinit var rndText: TextView;
    private lateinit var back: ImageButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)

        textView = findViewById(R.id.textView3)
        rndText = findViewById(R.id.rndText)
        back = findViewById(R.id.back)

        back.setOnClickListener { closeActivity() }

        addToLimit();
        getRandomNumber();
        setRndColor();
    }

    fun addToLimit() {
        var str: String = textView.text.toString()
        val count = intent.getIntExtra(RANDOM_TO, 0)

        str += " " + count.toString()

        textView.text = str
    }

    fun getRandomNumber() {
        val count = intent.getIntExtra(RANDOM_TO, 0)


        val rnd = (0..count).random()

        rndText.text = rnd.toString()
    }

    fun closeActivity() {
        this.finish()
    }

    fun setRndColor() {
        val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        rndText.setTextColor(color)
    }

}