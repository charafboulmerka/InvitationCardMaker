package com.jeddah.invitationcards.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.jeddah.invitationcards.Models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.jeddah.invitationcards.R
import com.jeddah.invitationcards.utils.mUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.layout_login.*
import kotlinx.android.synthetic.main.layout_register.*
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class LoginActivity : AppCompatActivity() {
    lateinit var mAuth : FirebaseAuth
    lateinit var mRef:DatabaseReference
    private lateinit var viewsList:ArrayList<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewsList = arrayListOf(edt_login_email,edt_login_password,edt_register_email,edt_register_password,login_btn,register_btn)
        mAuth= FirebaseAuth.getInstance()
        mRef = FirebaseDatabase.getInstance().reference.child("users")
        goLoginLabel.setOnClickListener {
            login_layout_included.visibility= View.VISIBLE
            register_layout_included.visibility= View.GONE
        }
        goRegisterLabel.setOnClickListener {
            login_layout_included.visibility= View.GONE
            register_layout_included.visibility= View.VISIBLE
        }
        val editEmailLogin = findViewById<EditText>(R.id.edt_login_email)
        val editPasswordLogin = findViewById<EditText>(R.id.edt_login_password)
        val editEmailRegister = findViewById<EditText>(R.id.edt_register_email)
        val editPasswordRegister = findViewById<EditText>(R.id.edt_register_password)

        login_btn.setOnClickListener {
            if(editEmailLogin.text.isEmpty()){
                MotionToast.createColorToast(this,
                    "خطأ في البيانات",
                    "الرجاء إدخال البريد الإلكتروني و إعادة المحاولة",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    null)
                editEmailLogin.error = "الرجاء إدخال البريد الإلكتروني"
            }else if(editPasswordLogin.text.isEmpty()){
                MotionToast.createColorToast(this,
                    "خطأ في البيانات",
                    "الرجاء إدخال كلمة المرور و إعادة المحاولة",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    null)
                editPasswordLogin.error = "الرجاء إدخال كلمة المرور"
            }else{
                goLogin(editEmailLogin.text.toString().trim(),editPasswordLogin.text.toString().trim())
            }

        }

        register_btn.setOnClickListener {
            if(editEmailRegister.text.isEmpty()){
                MotionToast.createColorToast(this,
                    "خطأ في البيانات",
                    "الرجاء إدخال البريد الإلكتروني و إعادة المحاولة",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    null)
                editEmailRegister.error = "الرجاء إدخال البريد الإلكتروني"
            }else if(editPasswordRegister.text.isEmpty()){
                MotionToast.createColorToast(this,
                    "خطأ في البيانات",
                    "الرجاء إدخال كلمة المرور و إعادة المحاولة",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    null)
                editPasswordRegister.error = "الرجاء إدخال كلمة المرور"
            }else{
                goRegister(edtUsername.text.toString().trim(),editEmailRegister.text.toString().trim(),editPasswordRegister.text.toString().trim())
            }
        }


    }

    fun goLogin(email:String,password:String){
        mUtils(this).runLoading(viewsList,login_signup_layout)
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
              val userUid = mAuth.currentUser!!.uid
                if (task.isSuccessful){
                    MotionToast.createColorToast(this,
                        "تمت العملية بنجاح",
                        "تم تسجيل الدخول الى حسابك نجاح",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        null)
                    mUtils(this).saveUserID(userUid)
                    getUserByID()

                }else{
                    MotionToast.createColorToast(this,
                        "حصل خطأ الرجاء تفقد إتصالك بالأنترنت",
                        task.exception!!.message!!,
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        null)
                    mUtils(this).stopLoading(viewsList,login_signup_layout)
                }
            }else{
                MotionToast.createColorToast(this,
                    "حصل خطأ الرجاء تفقد إتصالك بالأنترنت",
                    task.exception!!.message!!,
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    null)
                mUtils(this).stopLoading(viewsList,login_signup_layout)
            }

        }
    }

    fun getUserByID(){
        mRef.child(mAuth.currentUser!!.uid).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                mUtils(this@LoginActivity).saveUsername(user!!.username.toString())
                if (mAuth.currentUser!!.email=="admin@gmail.com"){
                    startActivity(Intent(this@LoginActivity,AdminPanel::class.java))
                    finish()
                }else{
                    startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    finish()
                }
                mUtils(this@LoginActivity).stopLoading(viewsList,login_signup_layout)

            }

            override fun onCancelled(error: DatabaseError) {
                mUtils(this@LoginActivity).stopLoading(viewsList,login_signup_layout)

            }

        })
    }


    fun goRegister(name:String,email:String,password:String){
        mUtils(this).runLoading(viewsList,login_signup_layout)
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                val userUid = mAuth.currentUser!!.uid
                mRef.child(userUid).setValue(User(userUid,email,name,"CLIENT")).addOnCompleteListener {
                    if (task.isSuccessful){
                        MotionToast.createColorToast(this,
                            "تمت العملية بنجاح",
                            "تم فتح حساب جديد بنجاح",
                            MotionToastStyle.SUCCESS,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            null)
                        mUtils(this).saveUserID(userUid)
                        mUtils(this).saveUsername(name)
                        mUtils(this).stopLoading(viewsList,login_signup_layout)
                        startActivity(Intent(this,MainActivity::class.java))
                    }else{
                        MotionToast.createColorToast(this,
                            "حصل خطأ الرجاء تفقد إتصالك بالأنترنت",
                            task.exception!!.message!!,
                            MotionToastStyle.ERROR,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            null)
                        mUtils(this).stopLoading(viewsList,login_signup_layout)
                    }
                }

            }else{
                MotionToast.createColorToast(this,
                    "حصل خطأ الرجاء تفقد إتصالك بالأنترنت",
                    task.exception!!.message!!,
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    null)
                mUtils(this).stopLoading(viewsList,login_signup_layout)
            }

        }
    }



}