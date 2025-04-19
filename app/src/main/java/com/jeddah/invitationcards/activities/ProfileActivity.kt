package com.jeddah.invitationcards.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.astritveliu.boom.Boom
import com.astritveliu.boom.utils.BoomUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.jeddah.invitationcards.Models.User
import com.jeddah.invitationcards.R
import com.jeddah.invitationcards.utils.mUtils
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    lateinit var mAuth : FirebaseAuth
    lateinit var mRef: DatabaseReference
    private lateinit var viewsList:ArrayList<View>
    lateinit var mUtils:mUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        viewsList = arrayListOf(profile_btn_home)
        mAuth=FirebaseAuth.getInstance()
        mRef = FirebaseDatabase.getInstance().reference.child("users")
        mUtils = mUtils(this)
        BoomUtils.boomAll(profile_btn_home,profile_pic,col1,col2,col3,col4)
        getUserByID()
        profile_btn_home.setOnClickListener { finish() }
    }

   fun getUserByID(){
       mUtils.runLoading(viewsList,profileMainLayout)
        mRef.child(mAuth.currentUser!!.uid).addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                mUtils.stopLoading(viewsList,profileMainLayout)
                profile_name.text = user!!.username.toString()
                profile_user_name.text = user.username.toString()
                profile_user_email.text = user.email.toString()
                profile_pic.text = user.username!![0].toString()
            }

            override fun onCancelled(error: DatabaseError) {
                mUtils.stopLoading(viewsList,profileMainLayout)
            }

        })
    }
}