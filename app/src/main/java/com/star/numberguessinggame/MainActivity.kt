package com.star.numberguessinggame

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickRandomNumbers()
    }

    fun leftButtonClick(view: View) {

        checkIfCorrectAnswer(true)
    }

    fun rightButtonClick(view: View) {

        checkIfCorrectAnswer(false)
    }

    fun eitherButtonClick(view: View) {

        checkIfCorrectAnswer(view == left_button)
    }

    private fun checkIfCorrectAnswer(isLeft: Boolean) {

        val leftNum = left_button.text.toString().toInt()
        val rightNum = right_button.text.toString().toInt()

        if ((isLeft && (leftNum > rightNum)) || (!isLeft && (leftNum < rightNum))) {
            points++
            Toast.makeText(this, "You got it!", Toast.LENGTH_SHORT).show()
        } else {
            points--
            Toast.makeText(this, "UC Davis may still take you.", Toast.LENGTH_SHORT).show()
        }

        points_tv.text = "Points: $points"

        pickRandomNumbers()
    }

    private fun pickRandomNumbers() {

        val r = Random()

        val num1 = r.nextInt(10)
        var num2 = num1

        while (num2 == num1) {
            num2 = r.nextInt(10)
        }

        left_button.text = "$num1"
        right_button.text = "$num2"
    }
}
