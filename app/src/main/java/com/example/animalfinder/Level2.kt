package com.example.animalfinder

import android.content.Intent
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

class Level2 : AppCompatActivity(), TextToSpeech.OnInitListener  {
    private var score = 0
    private var counter = 0
    private lateinit var tts : TextToSpeech
    private var sound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level2)
        val intent_get_2 = getIntent()
         score = intent_get_2.getIntExtra("score",0)
         counter = intent_get_2.getIntExtra("counter",0)
        tts = TextToSpeech(this,this)
    }


    override fun onResume() {
        super.onResume()
        if(counter == 5){
            findViewById<ImageView>(R.id.img2_1).setImageResource(R.drawable.wolf)
            findViewById<ImageView>(R.id.img2_2).setImageResource(R.drawable.eagle)
            findViewById<ImageView>(R.id.img2_3).setImageResource(R.drawable.elephant)

            findViewById<TextView>(R.id.level2_text).setText("Find Wolf")
        }
        if(counter == 6){
            findViewById<ImageView>(R.id.img2_1).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img2_2).setImageResource(R.drawable.lion)
            findViewById<ImageView>(R.id.img2_3).setImageResource(R.drawable.elephant)
            findViewById<TextView>(R.id.level2_text).setText("Find Elephant")
        }
        if(counter == 7){
            findViewById<ImageView>(R.id.img2_1).setImageResource(R.drawable.dog)
            findViewById<ImageView>(R.id.img2_2).setImageResource(R.drawable.eagle)
            findViewById<ImageView>(R.id.img2_3).setImageResource(R.drawable.cat)
            findViewById<TextView>(R.id.level2_text).setText("Find Cat")
        }
        if(counter ==5){
            speakOut("Find Wolf")
            Handler().postDelayed({
            if(sound == null){
                sound = MediaPlayer.create(this,R.raw.wolf_sound2)
                sound?.start()

            }
            },500)
        }else if(counter ==6){
            speakOut("Find Elephant")
                Handler().postDelayed({
            if(sound != null){
                sound = MediaPlayer.create(this,R.raw.elephant_sound)
                sound?.start()
            }
                },2000)
        }else{
            speakOut("Find Cat")
                    Handler().postDelayed({
            if(sound != null){
                sound = MediaPlayer.create(this,R.raw.cat_sound)
                sound?.start()

            }
                    },2000)
        }


    }
    private fun speakOut(text: String) {
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    fun level2_1_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 5){
            val situation = true
            score +=10
            counter += 1
            Toast.makeText(this,"You did right", Toast.LENGTH_SHORT).show()
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 6){
            val situation = false
            Toast.makeText(this,"You did wrong",Toast.LENGTH_SHORT).show()

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
    fun level2_2_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 5){
            val situation = false
            Toast.makeText(this,"You did wrong",Toast.LENGTH_SHORT).show()
            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 6){
            val situation = false
            Toast.makeText(this,"You did wrong",Toast.LENGTH_SHORT).show()
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
    fun level2_3_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 5){
            val situation = false
            Toast.makeText(this,"You did wrong",Toast.LENGTH_SHORT).show()
            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 6){
            val situation = true
            score +=10
            counter += 1
            Toast.makeText(this,"You did right", Toast.LENGTH_SHORT).show()
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else{

            val situation = true
            score +=10
            counter += 1
            Toast.makeText(this,"You did right", Toast.LENGTH_SHORT).show()
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)
        }
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            var result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","The Language specified is not supported!")

            }else{
                speakOut("Find Wolf")
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