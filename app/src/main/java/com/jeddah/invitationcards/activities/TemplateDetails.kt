package com.jeddah.invitationcards.activities

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.astritveliu.boom.Boom
import com.astritveliu.boom.utils.BoomUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.gson.Gson
import com.jeddah.invitationcards.Models.UserTemplate
import com.jeddah.invitationcards.PicEditor
import com.jeddah.invitationcards.R
import com.jeddah.invitationcards.utils.mUtils
import kotlinx.android.synthetic.main.activity_template_details.*
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class TemplateDetails : AppCompatActivity() {
    lateinit var mUserTemplate: UserTemplate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_template_details)
        mUtils(this)
        if (intent.extras != null) {
            val ItemString = intent.getStringExtra("userTemplate")
            mUserTemplate = Gson().fromJson(ItemString, UserTemplate::class.java)
        }
        user_design_title.text = mUserTemplate.title
        design_owner.text = mUserTemplate.username

        Boom(btn_buy_design)
        if (mUserTemplate.is_paid==1){
            design_price.text = mUserTemplate.price + " $"
            btn_buy_label.text = "شراء التصميم"
        }else{
            design_price.text = "مجـاني"
            btn_buy_label.text = "إستخدام التصميم"
        }
        Glide.with(this)
            .load(mUserTemplate.full_design_url)
            .centerCrop()
            .override(this.design_img.getWidth(), this.design_img.getHeight())
            .into(object : CustomTarget<Drawable?>() {

                override fun onLoadCleared(placeholder: Drawable?) {

                }
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable?>?) {
                    design_img.setImageDrawable(resource)
                }
            })

        btn_buy_design.setOnClickListener {
            if (mUserTemplate.is_paid!=1){
                goNext()
            }else{
                alertPayment()
            }

        }
    }

    fun goNext(){
        val it = Intent(this,PicEditor::class.java)
        it.putExtra("img",mUserTemplate.background_url)
        it.putExtra("full_img",mUserTemplate.full_design_url)
        it.putExtra("selection_type","client")
        startActivity(it)
    }

    fun alertPayment(){
        val builder = AlertDialog.Builder(this)
        val view= layoutInflater.inflate(R.layout.payment_model,null)
        builder.setView(view)
        val btnPaypal = view.findViewById<CardView>(R.id.btnPaypal)
        val btnVisa = view.findViewById<CardView>(R.id.btnVisa)
        val btnMasterCard = view.findViewById<CardView>(R.id.btnMasterCard)

        val btnBuy1 = view.findViewById<Button>(R.id.btnBuy1)
        val btnBuy2 = view.findViewById<Button>(R.id.btnBuy2)
        val btnBuy3 = view.findViewById<Button>(R.id.btnBuy3)

        val PaymentButtons = view.findViewById<LinearLayout>(R.id.payment_buttons)
        val PaypalPayView = view.findViewById<LinearLayout>(R.id.paypal_pay_view)
        val VisaPayView = view.findViewById<LinearLayout>(R.id.visa_pay_view)
        val MastercardPayView = view.findViewById<LinearLayout>(R.id.mastercard_pay_view)

        val dialog  = builder.create()
        btnBuy1.setOnClickListener {
            dialog.dismiss()
            alertBuy()
        }
        btnBuy2.setOnClickListener {
            dialog.dismiss()
            alertBuy()
        }
        btnBuy3.setOnClickListener {
            dialog.dismiss()
            alertBuy()
        }
        btnPaypal.setOnClickListener {
            PaymentButtons.visibility = View.GONE
            PaypalPayView.visibility = View.VISIBLE
            VisaPayView.visibility = View.GONE
            MastercardPayView.visibility = View.GONE
        }
        btnVisa.setOnClickListener {
            PaymentButtons.visibility = View.GONE
            PaypalPayView.visibility = View.GONE
            VisaPayView.visibility = View.VISIBLE
            MastercardPayView.visibility = View.GONE
        }
        btnMasterCard.setOnClickListener {
            PaymentButtons.visibility = View.GONE
            PaypalPayView.visibility = View.GONE
            VisaPayView.visibility = View.GONE
            MastercardPayView.visibility = View.VISIBLE
        }


        BoomUtils.boomAll(btnPaypal,btnVisa,btnMasterCard)

        builder.setNegativeButton("إلغاء"){ p1,p2->

        }

        dialog.show()
    }
    fun alertBuy(){
        val list:ArrayList<View> = arrayListOf(btn_buy_design)
        mUtils(this).runLoading(list,null)
        Handler().postDelayed({
            MotionToast.createColorToast(this,
                "تمت عملية الشراء بنجاح",
                "يمكنك الآن استخدام هذا التصميم",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                null)
            mUtils(this).stopLoading(list,null)
            goNext()
        },3000)
    }
}