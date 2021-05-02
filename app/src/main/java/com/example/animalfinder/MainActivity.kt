package com.example.animalfinder

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var tts : TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tts = TextToSpeech(this,this)


    }


    private fun speakOut(text: String) {
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    // val score: TextView = findViewById(R.id.score_text)

    fun start_click(view: View) {
        val intent = Intent(this,Level1::class.java)
        startActivity(intent)
    }


     override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            var result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","The Language specified is not supported!")

            }else{
                speakOut("Animal finder")
            }

        }else{
            Log.e("TTS","Initialization Failed!")
        }
    }

    public override fun onDestroy(){
        if(tts != null){
            tts!!.stop()
            tts!!.shutdown()

        }
        super.onDestroy()
    }
}