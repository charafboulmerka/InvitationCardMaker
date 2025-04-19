package com.jeddah.invitationcards.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.widget.ProgressBar
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Circle
import com.google.firebase.auth.FirebaseAuth
import com.jeddah.invitationcards.BuildConfig
import com.jeddah.invitationcards.Models.UserTemplate
import com.jeddah.invitationcards.R
import kotlinx.android.synthetic.main.header.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class mUtils {
    var mCtx:Context?=null
    lateinit var mAuth: FirebaseAuth
    private lateinit var mSharedPreferences: SharedPreferences
    constructor(mCtx:Context){
        mSharedPreferences = mCtx.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)
        mAuth = FirebaseAuth.getInstance()
        this.mCtx=mCtx
        val mAct = mCtx as Activity
        if (mAct.header_btn_back != null) {
            mAct.header_btn_back.setOnClickListener { mAct.finish() }
        }


    }




    fun saveUserBackgroundUrl(background_url:String){
        val editShared = mSharedPreferences.edit()
        editShared.putString("background_url",background_url)
        editShared.apply()
    }

    fun getUserBackgroundUrl():String{
        return mSharedPreferences.getString("background_url","")!!
    }

    fun saveUserFullDesignUrl(full_design_url:String){
        val editShared = mSharedPreferences.edit()
        editShared.putString("full_design_url",full_design_url)
        editShared.apply()
    }

    fun getUserFullDesignUrl():String{
        return mSharedPreferences.getString("full_design_url","")!!
    }

    fun saveUserID(user_id:String){
        val editShared = mSharedPreferences.edit()
        editShared.putString("user_id",user_id)
        editShared.apply()
    }

    fun getUserID():String{
        return mSharedPreferences.getString("user_id","null")!!
    }

    fun saveUsername(username:String){
        val editShared = mSharedPreferences.edit()
        editShared.putString("username",username)
        editShared.apply()
    }

    fun getUsername():String{
        return mSharedPreferences.getString("username","null")!!
    }









    fun clearAllData(){
        val editShared = mSharedPreferences.edit().clear()
        editShared.apply()
    }

    fun getTodayDate(): String? {
        val df: DateFormat = SimpleDateFormat("dd-MM-yyyy")
        return df.format(Date())
    }


    fun runLoading(listView:ArrayList<View>,layout:View?=null){
        val mAct = mCtx as Activity
        //SHOW LOADING CIRCLE
        val layoutLoading = mAct.findViewById<View>(R.id.mProgress)
        //MAKE LOADING CIRCLE VISIBLE
        layoutLoading.visibility = View.VISIBLE
        val progressBar = mAct.findViewById<View>(R.id.spin_kit) as ProgressBar
        val doubleBounce: Sprite = Circle()
        progressBar.indeterminateDrawable = doubleBounce

        for (i in listView){
        i.isEnabled = false
        }
    }

    fun stopLoading(listView:ArrayList<View>,layout:View?=null){
        val mAct = mCtx as Activity

        //HIDE LOADING CIRCLE
        val layoutLoading = mAct.findViewById<View>(R.id.mProgress)
        //MAKE LOADING CIRCLE INVISIBLE
        layoutLoading.visibility = View.GONE
        val progressBar = mAct.findViewById<View>(R.id.spin_kit) as ProgressBar
        val doubleBounce: Sprite = Circle()
        progressBar.indeterminateDrawable = doubleBounce
        for (i in listView){
            i.isEnabled = true
        }
    }

    fun shareApp() {
        val url = "http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
        var shareBody = ""
        shareBody = "أشارك معك أفضل تطبيق" +
                "\n حمله عن طريق الرابط التالي "+
                "\n \n $url"
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareSub = "مشاركة مع الأصدقاء"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        mCtx!!.startActivity(Intent.createChooser(sharingIntent, "النشر على "))
    }

    fun rateApp(){
        val url = "http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
        mCtx!!.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }



}