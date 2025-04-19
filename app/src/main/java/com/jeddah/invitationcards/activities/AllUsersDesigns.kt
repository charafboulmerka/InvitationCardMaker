package com.jeddah.invitationcards.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.jeddah.invitationcards.Models.UserTemplate
import com.jeddah.invitationcards.R
import com.jeddah.invitationcards.adapters.AllUsersDesignsAdapter
import com.jeddah.invitationcards.adapters.SelectDesignAdapter
import com.jeddah.invitationcards.utils.mUtils
import kotlinx.android.synthetic.main.header.*

class AllUsersDesigns : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var ViewlayoutManager: RecyclerView.LayoutManager
    var mUsersTemplatesList = ArrayList<UserTemplate>()

    lateinit var mType:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_users_designs)
        mType = intent.extras!!.getString("type","pending")
        header_title.text = "تصاميم الأعضاء"
        mUtils(this)
        getUsersTemplates()
        ViewlayoutManager = GridLayoutManager(this,2)
        viewAdapter = AllUsersDesignsAdapter(this, mUsersTemplatesList,mType)


        recyclerView = findViewById<RecyclerView>(R.id.mAllDesignsRec).apply {
            setHasFixedSize(true)
            ViewlayoutManager.isAutoMeasureEnabled = false
            layoutManager = ViewlayoutManager
            adapter = viewAdapter
        }
    }

    private fun getUsersTemplates() {
        mUsersTemplatesList.clear()
        FirebaseDatabase.getInstance().reference.child("templates")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (item in snapshot.children) {
                        val template = item.getValue(UserTemplate::class.java)
                        if (mType=="pending"){
                            if (template!!.status=="pending"){
                                mUsersTemplatesList.add(template)
                            }
                        }else if(mType=="active"){
                            if (template!!.status=="active"){
                                mUsersTemplatesList.add(template)
                            }
                        }else{
                            if (template!!.status=="active"){
                                mUsersTemplatesList.add(template)
                            }
                        }
                    }
                    viewAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }
}