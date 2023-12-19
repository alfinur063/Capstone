package com.example.capstoneproject.view.question

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.capstoneproject.R
import com.example.capstoneproject.database.model.getAnswerIndex
import com.example.capstoneproject.database.model.questionsWithOptions
import com.example.capstoneproject.database.repository.ResultState
import com.example.capstoneproject.database.room.Answer
import com.example.capstoneproject.database.room.AnswerDatabase
import com.example.capstoneproject.databinding.ActivityQuestionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding
    private lateinit var questionText: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var ageEditText: EditText
    private var currentQuestionIndex = 0
    private var isRadioButtonChecked = false
    private val userAnswers = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionText = binding.pertanyaan
        optionsRadioGroup = binding.multiplyChoice
        ageEditText = binding.pertanyaanUmur

        supportActionBar?.hide()


        binding.nextButton.setOnClickListener {
            handleNextButon()
        }
        optionsRadioGroup.setOnCheckedChangeListener { _,_->
            isRadioButtonChecked = true
        }
        showQuestion()
    }

    private fun showQuestion(){
       if(currentQuestionIndex < questionsWithOptions.size){
           val currentQuestion = questionsWithOptions[currentQuestionIndex]
           questionText.text = currentQuestion.question

           optionsRadioGroup.removeAllViews()

           if (currentQuestionIndex == 1){
               ageEditText.visibility = View.VISIBLE
               optionsRadioGroup.visibility = View.GONE
           }else{
               ageEditText.visibility = View.GONE
               optionsRadioGroup.visibility = View.VISIBLE

               for (i in currentQuestion.listOpstions.indices){
                   val radioButton = RadioButton(this)
                   radioButton.text = currentQuestion.listOpstions[i]
                   radioButton.id = i
                   optionsRadioGroup.addView(radioButton)
               }
           }
       }else{
           Toast.makeText(this, "Quiz is done", Toast.LENGTH_SHORT).show()
           showAnswer()
       }
    }

    private fun handleNextButon(){
        if (currentQuestionIndex < questionsWithOptions.size){
            val currentQuestion = questionsWithOptions[currentQuestionIndex]
            if (currentQuestionIndex == 1){
                val age = ageEditText.text.toString()
                if (age.isNotBlank()){
                    userAnswers.add(age)
                    currentQuestionIndex++
                    showQuestion()
                }else{
                    Toast.makeText(this, "silakan input usia anda", Toast.LENGTH_SHORT).show()
                }
            }else{
                val selectOption = optionsRadioGroup.checkedRadioButtonId
                if (selectOption != -1){
                    val selectAnswer = findViewById<RadioButton>(selectOption)?.text.toString()
                    userAnswers.add(selectAnswer)
                    currentQuestionIndex++
                    showQuestion()
                }else{
                    Toast.makeText(this, "Pilih jawaban anda", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showAnswer(){
        val answer = userAnswers.joinToString("\n")
        AlertDialog.Builder(this)
            .setTitle("Jawaban Pengguna")
            .setMessage(answer)
            .setPositiveButton("Ok"){ dialog,_ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun saveUserAnswer(questionIndex: Int, userAnswer: String){
        val answerIndex = getAnswerIndex(questionIndex, userAnswer)
        if (answerIndex != null){
            val userAnswerDao = AnswerDatabase.getDatabase(this).userAnswerDao()
            val userAnswerEntity = Answer(questionIndex = questionIndex, answerIndex = answerIndex)

            CoroutineScope(Dispatchers.IO).launch {
                userAnswerDao.insertAnswer(userAnswerEntity)
            }
        }else{
            Toast.makeText(this, "Penyimpanan data ke database gagal", Toast.LENGTH_SHORT).show()
        }
    }

}





//        val Currentquestion = questionsWithOptions[currentQuestionIndex]
//        questionText.text = Currentquestion.question
//
//        for (i in Currentquestion.listOpstions.indices) {
//            val radioButton = RadioButton(this)
//            radioButton.text = Currentquestion.listOpstions[i]
//            radioButton.id = i
//            optionsRadioGroup.addView(radioButton)
//        }
//
//        val nextButton : Button = binding.nextButton
//        nextButton.setOnClickListener {
//            val selectOptionId = optionsRadioGroup.checkedRadioButtonId
//
//            val selectedAnswer = findViewById<RadioButton>(selectOptionId)?.text.toString()
//
//            currentQuestionIndex++
//
//            if (currentQuestionIndex < questionsWithOptions.size){
//                val nextQuestion = questionsWithOptions[currentQuestionIndex]
//
//                for (i in nextQuestion.listOpstions.indices){
//                    val radioButton = RadioButton(this)
//                    radioButton.text = nextQuestion.listOpstions[i]
//                    radioButton.id = i
//                    optionsRadioGroup.addView(radioButton)
//                }
//            }else{
//                Toast.makeText(this, "Kuis Selesai", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}