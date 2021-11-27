package com.example.deved

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception



class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val background = object : Thread() {
            override fun run() {
                try {

                    Thread.sleep(2000) //Delays the screen for 5000 milliseconds
//                    Intent is an action / code that defines where to go / which action to take
//                    Intent below defines the movement from Splashscreen to MainActivity
                    val intent = Intent(baseContext, LoginActivity::class.java)
//                    baseContext : Splashscreen
//                    MainActivity: class.java :MainActivity
                    startActivity(intent)
                    finish()

                } catch (e: Exception) {//If there was an error in the try{} block
                    e.printStackTrace()
//                    print out the error

                }
            }
        }//.start()
        background.start()
    }
}
