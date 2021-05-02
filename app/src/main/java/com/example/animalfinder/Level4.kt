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

class Level4 : AppCompatActivity(), TextToSpeech.OnInitListener  {
    private var score = 0
    private var counter = 0
    private var sound: MediaPlayer? = null
    private lateinit var tts : TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level4)
        val intent_get_2 = getIntent()
        score = intent_get_2.getIntExtra("score",0)
        counter = intent_get_2.getIntExtra("counter",0)
        tts = TextToSpeech(this,this)
    }
    override fun onResume() {
        super.onResume()
        if(counter == 13){
            findViewById<ImageView>(R.id.img4_1).setImageResource(R.drawable.wolf)
            findViewById<ImageView>(R.id.img4_2).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img4_3).setImageResource(R.drawable.monkey)
            findViewById<ImageView>(R.id.img4_4).setImageResource(R.drawable.lion)
            findViewById<ImageView>(R.id.img4_5).setImageResource(R.drawable.dog)
            findViewById<ImageView>(R.id.img4_6).setImageResource(R.drawable.elephant)
            findViewById<TextView>(R.id.level4_text).setText("Find Elephant")
        }
        if(counter == 14){
            findViewById<ImageView>(R.id.img4_1).setImageResource(R.drawable.wolf)
            findViewById<ImageView>(R.id.img4_2).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img4_3).setImageResource(R.drawable.monkey)
            findViewById<ImageView>(R.id.img4_4).setImageResource(R.drawable.cat)
            findViewById<ImageView>(R.id.img4_5).setImageResource(R.drawable.eagle)
            findViewById<ImageView>(R.id.img4_6).setImageResource(R.drawable.elephant)
            findViewById<TextView>(R.id.level4_text).setText("Find Eagle")
        }
        if(counter == 15){
            findViewById<ImageView>(R.id.img4_1).setImageResource(R.drawable.wolf)
            findViewById<ImageView>(R.id.img4_2).setImageResource(R.drawable.tiger)
            findViewById<ImageView>(R.id.img4_3).setImageResource(R.drawable.monkey)
            findViewById<ImageView>(R.id.img4_4).setImageResource(R.drawable.cow)
            findViewById<ImageView>(R.id.img4_5).setImageResource(R.drawable.sheep)
            findViewById<ImageView>(R.id.img4_6).setImageResource(R.drawable.tiger)
            findViewById<TextView>(R.id.level4_text).setText("Find Cow")
        }
        if(counter ==13){
            speakOut("Find Elephant")
            Handler().postDelayed({
            if(sound == null){
                sound = MediaPlayer.create(this,R.raw.elephant_sound)
                sound?.start()
            }
            },2000)
        }else if(counter ==14){
            speakOut("Find Eagle")
                Handler().postDelayed({
            if(sound != null){
                sound = MediaPlayer.create(this,R.raw.eagle_sound)
                sound?.start()
            }
                },2000)
        }else{
            speakOut("Find Cow")
                    Handler().postDelayed({
            if(sound != null){
                sound = MediaPlayer.create(this,R.raw.cow_sound)
                sound?.start()
            }
                    },2000)
        }
    }
    private fun speakOut(text: String) {
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }
    fun level4_1_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 13){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 14){
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
    fun level4_2_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 13){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 14){
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
    fun level4_3_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 13){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 14){
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
    fun level4_4_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 13){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 14){
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
    fun level4_5_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 13){
            val situation = false
            Toast.makeText(this,"You did wrong", Toast.LENGTH_SHORT).show()

            counter += 1
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 14){
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
    fun level4_6_click(view: View) {
        val intent = Intent(this,NextActivity::class.java)
        if(counter == 13){
            val situation = true
            score +=10
            counter += 1
            Toast.makeText(this,"You did right", Toast.LENGTH_SHORT).show()
            intent.putExtra("situation",situation)
            intent.putExtra("score",score)
            intent.putExtra("counter",counter)
            startActivity(intent)

        }else if(counter == 14){
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
                speakOut("Find Elephant")
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
