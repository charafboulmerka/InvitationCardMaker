package com.jeddah.invitationcards.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jeddah.invitationcards.R
import kotlinx.android.synthetic.main.activity_admin_panel.*

class AdminPanel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)
        admin_btn_home.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        admin_pending_designs.setOnClickListener {
            startActivity(Intent(this,AllUsersDesigns::class.java).putExtra("type","pending"))
        }

        admin_all_desings.setOnClickListener {
            startActivity(Intent(this,AllUsersDesigns::class.java).putExtra("type","all"))
        }

    }
}