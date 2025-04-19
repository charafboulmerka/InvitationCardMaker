package com.jeddah.invitationcards.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.astritveliu.boom.Boom
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import com.jeddah.invitationcards.Models.DesignSelection
import com.jeddah.invitationcards.Models.UserTemplate
import com.jeddah.invitationcards.R
import com.jeddah.invitationcards.activities.TemplateDetails
import com.jeddah.invitationcards.utils.mUtils
import com.squareup.picasso.Picasso
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class AllUsersDesignsAdapter : RecyclerView.Adapter<AllUsersDesignsAdapter.mHolder> {

    var mLocalList= ArrayList<UserTemplate>()
    var mCtx: Context?=null
    var type:String?=null

    constructor(mCtx: Context, mList: ArrayList<UserTemplate>,type:String){
        mLocalList= mList
        this.mCtx=mCtx
        this.type=type

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item_selection_user,parent,false)
        return mHolder(view)
    }

    override fun getItemCount(): Int {
        return mLocalList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class mHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
        override fun onClick(v: View?) {
            Log.e("BUTTON","CLICKED")
        }
        var mImg = view.findViewById<ImageView>(R.id.post_img)
        var mDeleteBtn = view.findViewById<Button>(R.id.btn_delete_post)
        var btnsAccRej = view.findViewById<LinearLayout>(R.id.btns_acc_rej)
        var mAcceptBtn = view.findViewById<AppCompatButton>(R.id.btn_accepect_post)
        var mRejectBtn = view.findViewById<AppCompatButton>(R.id.btn_reject_post)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: mHolder, position: Int) {
        val item = mLocalList[position]
        Boom(holder.mImg)
        Boom(holder.mDeleteBtn)
        //IF ADMIN
        if (mUtils(mCtx!!).getUserID()=="9vozox8SwNROm7leVCMzAqIvf0U2"){
            if (type=="pending"){
                holder.btnsAccRej.visibility = View.VISIBLE
                holder.mDeleteBtn.visibility = View.GONE

            }else if (type=="all"){
                holder.mDeleteBtn.visibility = View.VISIBLE
                holder.btnsAccRej.visibility = View.GONE
            }
        }

        holder.mDeleteBtn.setOnClickListener {
            confirmationDelete(item,position)
        }

        holder.mAcceptBtn.setOnClickListener {
            newDesignStatus(item,position,"accepted")
        }

        holder.mRejectBtn.setOnClickListener {
            newDesignStatus(item,position,"rejected")
        }
        Picasso.get().load(item.full_design_url!!).into(holder.mImg)
        holder.mImg.setOnClickListener {
            val meditationItemString = Gson().toJson(item)
            val intent = Intent(
                mCtx,
                TemplateDetails::class.java
            )
            intent.putExtra("userTemplate", meditationItemString)
            (mCtx as Activity).startActivity(intent)

            holder.mDeleteBtn.setOnClickListener {
                confirmationDelete(item!!,position)
            }
        }
    }




    fun confirmationDelete(item:UserTemplate,position: Int){
        val builder = AlertDialog.Builder(mCtx)
        builder.setMessage("هل انت متأكد من حذفك لهذا التصميم؟")

        builder.setPositiveButton("حذف") { dialog, which ->
            mUtils(mCtx!!).runLoading(arrayListOf(),null)
            FirebaseDatabase.getInstance().reference.child("templates").child(item.id!!)
                .removeValue().addOnCompleteListener { task->
                    mUtils(mCtx!!).stopLoading(arrayListOf(),null)
                    if (task.isSuccessful){
                        MotionToast.createColorToast(mCtx!! as Activity,
                            "تمت العملية بنجاح",
                            "تم حذف التصميم بنجاح",
                            MotionToastStyle.SUCCESS,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            null)
                        mLocalList.removeAt(position)
                        notifyDataSetChanged()
                    }else{
                        MotionToast.createColorToast(mCtx!! as Activity,
                            "فشلت العملية",
                            "حصل خظأ اثناء محاولة الحذف, الرجاء إعادة المحاولة لاحقا",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            null)
                    }
                }
        }

        builder.setNegativeButton("إلغاء") { dialog, which ->

        }

        builder.show()
    }

    fun newDesignStatus(item:UserTemplate,position: Int,action:String){
        val builder = AlertDialog.Builder(mCtx)
        var newStatus = ""
        if (action=="accepted"){
            builder.setMessage("هل انت متأكد من قبولك لهذا التصميم؟")
            newStatus="active"
        }else{
            builder.setMessage("هل انت متأكد من رفضك لهذا التصميم؟")
            newStatus="rejected"
        }

        builder.setPositiveButton("نعم") { dialog, which ->
            mUtils(mCtx!!).runLoading(arrayListOf(),null)
            FirebaseDatabase.getInstance().reference.child("templates").child(item.id!!)
                .child("status").setValue(newStatus).addOnCompleteListener { task->
                    mUtils(mCtx!!).stopLoading(arrayListOf(),null)
                    if (task.isSuccessful){
                        MotionToast.createColorToast(mCtx!! as Activity,
                            "إكتملت العملية !!",
                            "تمت العملية بنجاح",
                            MotionToastStyle.SUCCESS,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            null)
                        mLocalList.removeAt(position)
                        notifyDataSetChanged()
                    }else{
                        MotionToast.createColorToast(mCtx!! as Activity,
                            "فشلت العملية",
                            "حصل خظأ الرجاء إعادة المحاولة لاحقا",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            null)
                    }
                }
        }

        builder.setNegativeButton("إلغاء") { dialog, which ->

        }

        builder.show()
    }


}