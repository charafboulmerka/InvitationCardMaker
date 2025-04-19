package com.jeddah.invitationcards.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.animation.ObjectAnimator
import android.content.Intent
import android.widget.LinearLayout
import androidx.core.animation.doOnEnd
import com.google.firebase.auth.FirebaseAuth
import com.jeddah.invitationcards.R


class SplashActivity : AppCompatActivity() {

    private lateinit var imgLogo : LinearLayout
    var hasAnimationStarted:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


         imgLogo = findViewById(R.id.mSplash)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && !hasAnimationStarted) {
            hasAnimationStarted = true
            val metrics = resources.displayMetrics
            val translationY = ObjectAnimator.ofFloat(
                imgLogo,
                "y",
                metrics.heightPixels / 2 - imgLogo.height.toFloat() / 2
            ) // metrics.heightPixels or root.getHeight()
            translationY.duration = 1000
            translationY.start()
            translationY.doOnEnd {
                if (FirebaseAuth.getInstance().currentUser!=null){
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }else{
                   // if (FirebaseAuth.getInstance().currentUser!!.email=="admin@gmail.com"){

                    //}
                    startActivity(Intent(this,LoginActivity::class.java))
                    finish()
                }

            }
        }


    }



}
