package com.example.animalfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class NextActivity : AppCompatActivity(), TextToSpeech.OnInitListener  {
    private var score = 0
    private var situation = true
    private var counter = 1
    private lateinit var tts : TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

       val intent_next_get = getIntent()
        if(intent_next_get != null){
            score = intent_next_get.getIntExtra("score",0)
            situation = intent_next_get.getBooleanExtra("situation",true)
            counter = intent_next_get.getIntExtra("counter",0)
            tts = TextToSpeech(this,this)
            val text = findViewById<TextView>(R.id.score_text)

            if(counter == 20){
                text.text = "Congratulations\n"+ score.toString()
                findViewById<Button>(R.id.next_button).setText("Finish")
            }else{
                text.text = score.toString()
            }
            Log.d("NextActivity", "$score")

            if(situation == false){
                findViewById<Button>(R.id.next_button).setText("Try Again")
            }
        }
    }



    fun next_button_click(view: View) {
        val intent_next_get = getIntent()
        counter = intent_next_get.getIntExtra("counter",0)
        Log.d("counter", counter.toString())
        if(counter <= 4) {
            if (situation && counter == 4) {
//Log.d("NextActivity", "Buraya Girdi")
                val intent = Intent(this, Level2::class.java)
                intent.putExtra("score", score)
                counter++
                intent.putExtra("counter", counter)
                startActivity(intent)

            } else if (situation) {
                val intent = Intent(this, Level1::class.java)
                intent.putExtra("counter", counter)
                //startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        else if(counter >4 && counter <=8 ){
            if (situation && counter == 8) {
//Log.d("NextActivity", "Buraya Girdi")
                val intent = Intent(this, Level3::class.java)
                intent.putExtra("score", score)
                counter++
                intent.putExtra("counter", counter)
                startActivity(intent)

            } else if (situation) {
                val intent = Intent(this, Level2::class.java)
                intent.putExtra("counter", counter)
                //startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }else if(counter >8 && counter <=12 ){
            if (situation && counter == 12) {
//Log.d("NextActivity", "Buraya Girdi")
                val intent = Intent(this, Level4::class.java)
                intent.putExtra("score", score)
                counter++
                intent.putExtra("counter", counter)
                startActivity(intent)

            } else if (situation) {
                val intent = Intent(this, Level3::class.java)
                intent.putExtra("counter", counter)
                //startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }else if(counter >12 && counter <=16 ){
            if (situation && counter == 16) {
//Log.d("NextActivity", "Buraya Girdi")
                val intent = Intent(this, Level5::class.java)
                intent.putExtra("score", score)
                counter++
                intent.putExtra("counter", counter)
                startActivity(intent)

            } else if (situation) {
                val intent = Intent(this, Level4::class.java)
                intent.putExtra("counter", counter)
                //startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }else{
            if (situation && counter == 20) {
//Log.d("NextActivity", "Buraya Girdi")
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("score", score)
                counter++
                intent.putExtra("counter", counter)
                startActivity(intent)

            } else if (situation) {
                val intent = Intent(this, Level5::class.java)
                intent.putExtra("counter", counter)
                //startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
    private fun speakOut(text: String) {
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            var result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","The Language specified is not supported!")

            }else{
                if(situation && counter == 20){
                    speakOut("Answer is right,Congratulations, your score is"+score.toString())
                }else if(situation){
                    speakOut("Answer is right, your score is"+score.toString())
                }
                else{
                    speakOut("Answer is wrong, try again your score is"+score.toString())
                }
            }

        }else{
            Log.e("TTS","Initialization Failed!")
        }
    }


}

