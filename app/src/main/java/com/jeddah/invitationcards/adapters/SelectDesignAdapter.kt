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
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.astritveliu.boom.Boom
import com.github.dhaval2404.imagepicker.ImagePicker
import com.jeddah.invitationcards.Models.DesignSelection
import com.jeddah.invitationcards.PicEditor
import com.jeddah.invitationcards.R
import com.squareup.picasso.Picasso

class SelectDesignAdapter : RecyclerView.Adapter<SelectDesignAdapter.mHolder> {

    var mLocalList= ArrayList<DesignSelection>()
    var mCtx: Context?=null

    constructor(mCtx: Context, mList: ArrayList<DesignSelection>){
        mLocalList= mList
        this.mCtx=mCtx

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item_selection,parent,false)
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
        var mImg = view.findViewById<ImageView>(R.id.img)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: mHolder, position: Int) {
        val item = mLocalList[position]
        Boom(holder.mImg)
        Picasso.get().load(item.img!!).into(holder.mImg)
        holder.mImg.setOnClickListener {
            if (item.type=="upload"){
                ImagePicker.with(mCtx as Activity)
                    .crop() //Crop image(Optional), Check Customization for more option
                    //.compress(1024)			//Final image size will be less than 1 MB(Optional)
                    //.maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                    .start()
            }else if (item.type=="blank"){
                val it = Intent(mCtx,PicEditor::class.java)
                it.putExtra("img",R.drawable.empty_design_back)
                it.putExtra("selection_type",item.type!!)
                mCtx!!.startActivity(it)
            }else{
                val it = Intent(mCtx,PicEditor::class.java)
                it.putExtra("img",item.img!!)
                it.putExtra("selection_type",item.type!!)
                mCtx!!.startActivity(it)
            }
        }
    }




    fun confirmationDelete(item:DesignSelection,position: Int){
        val builder = AlertDialog.Builder(mCtx)
        builder.setMessage("هل انت متأكد من حذفك لهذا الحلم؟")

        builder.setPositiveButton("حذف") { dialog, which ->
        }

        builder.setNegativeButton("إلغاء") { dialog, which ->

        }

        builder.show()
    }


}