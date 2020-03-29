package com.mydemoapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mydemoapp.databinding.ActivitySplashBinding
import com.mydemoapp.view.LoginActivity

class SplashActivity : AppCompatActivity() {

    // private var mDelayHandler: Handler? = null
    private val SPLASH_TIME_OUT: Long = 500 //5 seconds
    private var mSplashBinding: ActivitySplashBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app login activity
            startActivity(Intent(this, LoginActivity::class.java))
            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}