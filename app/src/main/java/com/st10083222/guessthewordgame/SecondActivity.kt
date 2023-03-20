package com.st10083222.guessthewordgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*


class SecondActivity : AppCompatActivity() {

    lateinit var tvName: TextView

    lateinit var day: String
    lateinit var random: Random

    // Declaring variable for the views
    lateinit var txtRightAnswer: TextView
    lateinit var txtQuestionContainer: TextView
    lateinit var txtCorrectAnswer: TextView
    lateinit var etUserInput: EditText
    lateinit var btShow: Button
    lateinit var btCheck: Button
    lateinit var btNext: Button

    // Declaring Array of String
    internal var Days = arrayOf(
        "Human", "Eagle", "Lion", "Whale", "Cheetah", "Zebra", "Meercat"

    )

    ///////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvName = findViewById(R.id.tvName)

        val bundle = intent.extras
        if (bundle != null) {
            tvName.text = "Hello ${bundle.getString("name")}"

            ///////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////

            txtRightAnswer = findViewById(R.id.txtRightAnswer)
            txtQuestionContainer = findViewById(R.id.txtQuestionContainer)
            txtCorrectAnswer = findViewById(R.id.txtCorrectAnswer)

            etUserInput = findViewById(R.id.etUserInput)

            btShow = findViewById(R.id.btShow)
            btNext = findViewById(R.id.btNext)
            btCheck = findViewById(R.id.btCheck)


            random = Random()

            fun mixWords(word: String): String {

                val word =
                    Arrays.asList<String>(
                        *word.split("".toRegex()).dropLastWhile({ it.isEmpty() })
                            .toTypedArray()
                    )
                Collections.shuffle(word)
                var mixed = ""

                for (i in word) {
                    mixed += i
                }
                return mixed

            }

            day = Days[random.nextInt(Days.size)]
            txtQuestionContainer.text = mixWords(day)


            /*Button 1*/
            btNext.setOnClickListener {

                day = Days[random.nextInt(Days.size)]
                txtQuestionContainer.text = mixWords(day)


                etUserInput.setText("")
                txtRightAnswer.visibility = View.INVISIBLE
                txtCorrectAnswer.visibility = View.INVISIBLE

            }

            /*Button 2*/
            btCheck.setOnClickListener {

                if (etUserInput.text.toString().equals(day, ignoreCase = true)) {

                    Toast.makeText(this@SecondActivity, "You Got It", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SecondActivity, "You Failed", Toast.LENGTH_SHORT).show()
                }


            }

            /*Button 3*/
            btShow.setOnClickListener {
                txtCorrectAnswer.visibility = View.VISIBLE
                txtRightAnswer.visibility = View.VISIBLE

                txtRightAnswer.text = day


            }

        }
    }
}
