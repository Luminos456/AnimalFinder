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

class Level5 : AppCompatActivity(), TextToSpeech.OnInitListener  {
    private var score = 0
    private var counter = 0
    private var sound: MediaPlayer? = null
    private lateinit var tts : TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level5)
        val intent_get_2 = getIntent()
        score = intent_get_2.getIntExtra("score",0)
        counter = intent_get_2.getIntExtra("counter",0)
        tts = TextToSpeech(this,this)
    }
    override fun onResume() {
        super.onResume()
        if(counter == 17){
            findViewById<ImageView>(R.id.img5_1).setImageResource(R.drawable.sheep)
            findViewById<ImageView>(R.id.img5_2).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img5_3).setImageResource(R.drawable.cow)
            findViewById<ImageView>(R.id.img5_4).setImageResource(R.drawable.eagle)
            findViewById<ImageView>(R.id.img5_5).setImageResource(R.drawable.monkey)
            findViewById<ImageView>(R.id.img5_6).setImageResource(R.drawable.lion)
            findViewById<ImageView>(R.id.img5_7).setImageResource(R.drawable.dog)
            findViewById<ImageView>(R.id.img5_8).setImageResource(R.drawable.cat)
            findViewById<TextView>(R.id.level5_text).setText("Find Cow")
        }
        if(counter == 18){
            findViewById<ImageView>(R.id.img5_1).setImageResource(R.drawable.sheep)
            findViewById<ImageView>(R.id.img5_2).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img5_3).setImageResource(R.drawable.monkey)
            findViewById<ImageView>(R.id.img5_4).setImageResource(R.drawable.elephant)
            findViewById<ImageView>(R.id.img5_5).setImageResource(R.drawable.cow)
            findViewById<ImageView>(R.id.img5_6).setImageResource(R.drawable.lion)
            findViewById<ImageView>(R.id.img5_7).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img5_8).setImageResource(R.drawable.cat)
            findViewById<TextView>(R.id.level5_text).setText("Find Sheep")
        }
        if(counter == 19){
            findViewById<ImageView>(R.id.img5_1).setImageResource(R.drawable.wolf)
            findViewById<ImageView>(R.id.img5_2).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img5_3).setImageResource(R.drawable.monkey)
            findViewById<ImageView>(R.id.img5_4).setImageResource(R.drawable.eagle)
            findViewById<ImageView>(R.id.img5_5).setImageResource(R.drawable.dog)
            findViewById<ImageView>(R.id.img5_6).setImageResource(R.drawable.cow)
            findViewById<ImageView>(R.id.img5_7).setImageResource(R.drawable.sheep)
            findViewById<ImageView>(R.id.img5_8).setImageResource(R.drawable.elephant)
            findViewById<TextView>(R.id.level5_text).setText("Find Tiger")
        }
        if(counter ==17){
            speakOut("Find Cow")
            Handler().postDelayed({
                if(sound == null){
                    sound = MediaPlayer.create(this,R.raw.cow_sound)
                    sound?.start()
                }
            },1500)
        }else if(counter ==18){
            speakOut("Find Sheep")
            Handler().postDelayed({
            if(sound != null){
                sound = MediaPlayer.create(this,R.raw.sheep_sound)
                sound?.start()
            }
        },1500)
        }else{
            speakOut("Find Tiger")
            Handler().postDelayed({
            if(sound != null){
                sound = MediaPlayer.create(this,R.raw.tiger_sound)
                sound?.start()
            }
            },1500)
        }
    }
    private fun speakOut(text: String) {
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    fun level5_1_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 17){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 18){
            val situation = true
            score +=10
            counter += 1
            Toast.makeText(this,"You did right", Toast.LENGTH_SHORT).show()
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else{
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }
    }
    fun level5_2_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 17){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 18){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
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
    fun level5_3_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 17){
            val situation = true
            score +=10
            counter += 1
            Toast.makeText(this,"You did right", Toast.LENGTH_SHORT).show()
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 18){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else{
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }
    }
    fun level5_4_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 17){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 18){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else{
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }
    }
    fun level5_5_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 17){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 18){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else{
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }
    }
    fun level5_6_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 17){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 18){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else{
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }
    }
    fun level5_7_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 17){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 18){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else{
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }
    }
    fun level5_8_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 17){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 18){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else{
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
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
                speakOut("Find Cow")
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