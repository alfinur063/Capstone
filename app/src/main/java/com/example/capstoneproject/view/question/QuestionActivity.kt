package com.example.capstoneproject.view.question

import android.content.Intent
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
import androidx.lifecycle.ViewModelProvider
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.database.api.ApiService
import com.example.capstoneproject.database.model.questionsWithOptions
import com.example.capstoneproject.database.repository.Repository
import com.example.capstoneproject.database.repository.ResultState
import com.example.capstoneproject.database.response.UserAnswerResponse
import com.example.capstoneproject.database.room.Answer
import com.example.capstoneproject.database.room.AnswerDatabase
import com.example.capstoneproject.databinding.ActivityQuestionBinding
import com.example.capstoneproject.view.recomendation.RecommendationActivity
import com.google.gson.JsonArray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding
    private lateinit var questionText: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var ageEditText: EditText
    private var currentQuestionIndex = 0
    private var isRadioButtonChecked = false
    private val userAnswers = mutableListOf<Int>()
  //  private lateinit var userAnswerRepository : Repository
    private lateinit var questionViewModel: QuestionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionText = binding.pertanyaan
        optionsRadioGroup = binding.multiplyChoice
        ageEditText = binding.pertanyaanUmur

        supportActionBar?.hide()

        //userAnswerViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

       // questionViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)


        binding.nextButton.setOnClickListener {
            handleNextButon()
        }
        binding.previous.setOnClickListener{
            previousButton()
        }
        binding.resultUser.setOnClickListener {
//            val jsonArrayToSend: JsonArray = questionViewModel.getUserAnswersAsJsonArray()
//            sendDataToAPI(jsonArrayToSend)
            showAnswer()
            val intent = Intent(this, RecommendationActivity::class.java)
            startActivity(intent)
            finish()
        }

        optionsRadioGroup.setOnCheckedChangeListener { _,_->
            isRadioButtonChecked = true
        }

        showQuestion()

//        val usersAnswer = 5
//        questionViewModel.addUsersAnswer(usersAnswer)
//        val jsonArrayToSend: JsonArray = questionViewModel.getUserAnswersAsJsonArray()

    }

    private fun showQuestion(){
       if(currentQuestionIndex < questionsWithOptions.size){
           val currentQuestion = questionsWithOptions[currentQuestionIndex]
           questionText.text = currentQuestion.question

           val previousButton: Button = binding.previous
           val nextButon: Button = binding.nextButton
           val resultButton: Button = binding.resultUser
          // nextButon.visibility = if (currentQuestionIndex == questionsWithOptions.size - 1) View.GONE else View.VISIBLE
           previousButton.visibility = if (currentQuestionIndex == 0) View.GONE else View.VISIBLE
           resultButton.visibility = if (currentQuestionIndex == questionsWithOptions.size -1)View.VISIBLE else View.GONE
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
       }
    }

    private fun handleNextButon(){
        if (currentQuestionIndex < questionsWithOptions.size){
            val currentQuestion = questionsWithOptions[currentQuestionIndex]
            if (currentQuestionIndex == 1){
                val age = ageEditText.text.toString()
                if (age.isNotBlank()){
                    val ageInt = age.toInt()
                    userAnswers.add(ageInt)
                    //saveUserAnswer(currentQuestionIndex, ageInt)
                    currentQuestionIndex++
                    showQuestion()
                }else{
                    Toast.makeText(this, "silakan input usia anda", Toast.LENGTH_SHORT).show()
                }
            }else{
                val selectOption = optionsRadioGroup.checkedRadioButtonId
                if (selectOption != -1){
                    val selectAnswer = findViewById<RadioButton>(selectOption)?.text.toString()
                    val answerIndex = currentQuestion.listOpstions.indexOf(selectAnswer)
                    userAnswers.add(answerIndex)
                    //saveUserAnswer(currentQuestionIndex, answerIndex)
                    currentQuestionIndex++
                    showQuestion()
                }else{
                    Toast.makeText(this, "Pilih jawaban anda", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun previousButton(){
        if (currentQuestionIndex > 0){
            currentQuestionIndex--
            showQuestion()
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

//    private fun saveUserAnswer(questionIndex: Int, userAnswer: Int){
//            val userAnswerDao = AnswerDatabase.getDatabase(this).userAnswerDao()
//            val userAnswerEntity = Answer(questionIndex = questionIndex, answerIndex = userAnswer)
//
//            CoroutineScope(Dispatchers.IO).launch {
//                userAnswerRepository.addUserAnswer(questionIndex, userAnswer)
//            }
//    }


//    private fun displayAnswer(){
//        val userAnswerDao = AnswerDatabase.getDatabase(this).userAnswerDao()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val usersAnswer = userAnswerDao.getAllAnswerUser()
//
//        for (answer in usersAnswer){
//            Log.d("User Answer", "Question ${answer.questionIndex}: ${answer.answerIndex}")
//        }
//        }
//    }

    private fun addAnswer(answerIndex: Int){
        userAnswers.add(answerIndex)
    }

//    private fun sendUserAnswerToAPI(){
//        val userAnswerRespone = UserAnswerResponse(userAnswers)
//        sendDataToAPI(userAnswerRespone)
//    }

//    private fun sendDataToAPI(jsonArrayToSend: JsonArray){
//        val retrofit = Retrofit.Builder()
//            val alluserAnswer = userAnswerRepository.getAllUserAnswer()
//                val userAnswerToSend =List<Int> = listOf(1,2,3,4,5)
//                    val userAnswerArray: Array<Int> = userAnswers.toTypedArray()
//            .baseUrl("https://backend-dot-healtheats-dev.et.r.appspot.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val apiService = retrofit.create(ApiService::class.java)
//
//       CoroutineScope(Dispatchers.IO).launch {
//           try {
//               val response = apiService.SendUserAnswer(jsonArrayToSend)
//               withContext(Dispatchers.Main) {
//                   if (response != null) {
//                       runOnUiThread {
//                           Toast.makeText(
//                               this@QuestionActivity,
//                               "Data telah terkirim ke API",
//                               Toast.LENGTH_SHORT
//                           ).show()
//                       }
//                   } else {
//                       runOnUiThread {
//                           Toast.makeText(
//                               this@QuestionActivity,
//                               "Gagal mengirim data ke API",
//                               Toast.LENGTH_SHORT
//                           ).show()
//                       }
//                   }
//               }
//           }catch (e: Exception){
//               withContext(Dispatchers.Main){
//                   Toast.makeText(this@QuestionActivity,
//                       "Terjadi Kesalahan: ${e.message}",
//                       Toast.LENGTH_SHORT
//                   ).show()
//               }
//           }
//       }
//    }

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