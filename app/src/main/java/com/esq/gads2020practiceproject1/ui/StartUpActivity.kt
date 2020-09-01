package com.esq.gads2020practiceproject1.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.esq.gads2020practiceproject1.MainActivity
import com.esq.gads2020practiceproject1.R

class StartUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up)
        Handler().postDelayed({
            startActivity(
                Intent(
                    this@StartUpActivity,
                    MainActivity::class.java
                )
            )
        }, 3000)
    }
}
