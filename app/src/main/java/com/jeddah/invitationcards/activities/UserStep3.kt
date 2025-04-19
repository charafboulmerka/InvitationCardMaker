package com.jeddah.invitationcards.activities

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.FirebaseDatabase
import com.jeddah.invitationcards.Models.UserTemplate
import com.jeddah.invitationcards.R
import com.jeddah.invitationcards.utils.mUtils
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener
import kotlinx.android.synthetic.main.activity_user_step3.*
import kotlinx.android.synthetic.main.header_design.*
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class UserStep3 : AppCompatActivity() {
    private lateinit var viewsList:ArrayList<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_step3)
        header_title.text = "المرحلة الأخيرة : ملئ البيانات"
        mUtils(this)
        sp_isfree.selectItemByIndex(0)
        sp_category.selectItemByIndex(0)

        sp_isfree.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newText ->
            if (newIndex==0){
                design_price.visibility = View.GONE
            }else{
                design_price.visibility = View.VISIBLE
            }
        }

        btn_save_design.setOnClickListener {
            if (design_price.text.isEmpty() && sp_isfree.selectedIndex==1){
                MotionToast.createColorToast(this,
                    "خطأ في السعر",
                    "الرجاء إدخال السعر و إعادة المحاولة",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    null)
            }else if(design_title.text.isEmpty()){
                MotionToast.createColorToast(this,
                    "خطأ في عنوان التصميم",
                    "الرجاء كتابة عنوان التصميم و إعادة المحاولة",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    null)
            }else{
                saveDesignToFirebase()
            }
        }
    }

    fun saveDesignToFirebase(){
        var designPrice = "0"
        if (sp_isfree.selectedIndex!=0){
            viewsList = arrayListOf(btn_save_design,design_price,design_title,sp_category,sp_isfree)
            designPrice=design_price.text.toString()

        }else{
            viewsList = arrayListOf(btn_save_design,design_title,sp_category,sp_isfree)
        }
        mUtils(this).runLoading(viewsList,null)
       val firebasePush = FirebaseDatabase.getInstance().reference.child("templates").push()
        firebasePush.setValue(UserTemplate(firebasePush.key.toString(),design_title.text.toString(),
        sp_isfree.selectedIndex,designPrice,mUtils(this).getUserID(),mUtils(this).getUsername(),mUtils(this).getUserBackgroundUrl()
            ,mUtils(this).getUserFullDesignUrl(),sp_category.selectedIndex,"pending"))
            .addOnCompleteListener { task->
                mUtils(this).stopLoading(viewsList,null)
                if (task.isSuccessful){
                    MotionToast.createColorToast(this,
                        "تم إضافة طلبك بنجاح",
                        " التصميم تحت المعاينة",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        null)
                    startActivity(Intent(this,MainActivity::class.java))
                }else{
                    MotionToast.createColorToast(this,
                        "حصل خطأ !!",
                        "الرجاء إعادة المحاولة",
                        MotionToastStyle.WARNING,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        null)
                }

            }


    }
}