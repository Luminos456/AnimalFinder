package com.example.animalfinder

import android.content.Intent
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class Level1 : AppCompatActivity(), TextToSpeech.OnInitListener  {
    private lateinit var tts : TextToSpeech
    private var sound: MediaPlayer? = null
    var counter = 1
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1)

        tts = TextToSpeech(this,this)

    }

    override fun onResume() {
        super.onResume()
        if(counter == 2){
            findViewById<ImageView>(R.id.img1).setImageResource(R.drawable.dog)
            findViewById<ImageView>(R.id.img2).setImageResource(R.drawable.eagle)
            findViewById<TextView>(R.id.level1_text).setText("Find Dog")
        }
        if(counter == 3){
            findViewById<ImageView>(R.id.img1).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img2).setImageResource(R.drawable.lion)
            findViewById<TextView>(R.id.level1_text).setText("Find lion")
        }
        if(counter ==1){
            speakOut("Find Cat")
            Handler().postDelayed({
            if(sound == null){
                sound = MediaPlayer.create(this,R.raw.cat_sound)
                sound?.start()
            }
        },1500)
        }else if(counter ==2){
            speakOut("Find Dog")
            Handler().postDelayed({
            if(sound != null){
                sound = MediaPlayer.create(this,R.raw.dog_sound)
                sound?.start()
            }
            },2000)
        }else{
            speakOut("Find Lion")
                Handler().postDelayed({
            if(sound != null){
                sound = MediaPlayer.create(this,R.raw.lion_sound)
                sound?.start()
            }
                },2000)

        }

    }

    private fun speakOut(text: String) {
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }


    fun level1_1_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter ==1 ){
            val situation = true
            score +=10
            counter += 1
            Toast.makeText(this,"You did right",Toast.LENGTH_SHORT).show()
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)
        }else if(counter ==2){
            val situation = true
            score +=10
            Toast.makeText(this,"You did right",Toast.LENGTH_SHORT).show()
            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)
        }else{
            val situation = false
            Toast.makeText(this,"You did wrong",Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)
        }

    }

    fun level1_2_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter ==1 ){
            val situation = false
            Toast.makeText(this,"You did wrong",Toast.LENGTH_SHORT).show()
            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)
        }else if(counter ==2){
            val situation = false
            Toast.makeText(this,"You did wrong",Toast.LENGTH_SHORT).show()
            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)
        }else{
            val situation = true
            Toast.makeText(this,"You did right",Toast.LENGTH_SHORT).show()
            counter += 1
            score +=10
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)
        }}

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            var result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","The Language specified is not supported!")

            }else{
                if(counter ==1){
                    speakOut("Find Cat")
                }else if(counter ==2){
                    speakOut("Find Dog")
                }else{
                    speakOut("Find Lion")
                }

            }

        }else{
            Log.e("TTS","Initialization Failed!")
        }
    }

    public override fun onDestroy(){

        super.onDestroy()
        if(tts != null){
            tts!!.stop()
            tts!!.shutdown()
            sound?.stop()
            sound?.reset()
            sound?.release()
        }
    }


}