package com.jeddah.invitationcards.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jeddah.invitationcards.Models.DesignSelection
import com.jeddah.invitationcards.PicEditor
import com.jeddah.invitationcards.R
import com.jeddah.invitationcards.adapters.SelectDesignAdapter
import com.jeddah.invitationcards.utils.mUtils
import kotlinx.android.synthetic.main.header.*

class UserSelectDesign : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var ViewlayoutManager: RecyclerView.LayoutManager


    private var mList = ArrayList<DesignSelection>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_select_design)
        header_title.text = "إختر التصميم"
        mUtils(this)
        getList()
        ViewlayoutManager = GridLayoutManager(this,2)

        viewAdapter = SelectDesignAdapter(this, mList)


        recyclerView = findViewById<RecyclerView>(R.id.mDesRec).apply {
            setHasFixedSize(true)
            ViewlayoutManager.isAutoMeasureEnabled = false
            layoutManager = ViewlayoutManager
            adapter = viewAdapter
        }

    }

    fun getList(){
        mList.clear()
        mList.add(DesignSelection(R.drawable.empty_design,"blank"))
        mList.add(DesignSelection(R.drawable.upload_design,"upload"))
        mList.add(DesignSelection(R.drawable.engagement_card_1_back,"app_design"))
        mList.add(DesignSelection(R.drawable.engagement_card_2_back,"app_design"))
        mList.add(DesignSelection(R.drawable.engagement_card_3_back,"app_design"))
        mList.add(DesignSelection(R.drawable.wedding_card_4_back,"app_design"))
        mList.add(DesignSelection(R.drawable.wedding_card_5_back,"app_design"))
        mList.add(DesignSelection(R.drawable.wedding_card_6_back,"app_design"))
        mList.add(DesignSelection(R.drawable.birthday_cards_7_back,"app_design"))
        mList.add(DesignSelection(R.drawable.birthday_cards_8_back,"app_design"))
        mList.add(DesignSelection(R.drawable.birthday_cards_9_back,"app_design"))
        mList.add(DesignSelection(R.drawable.anniversary_card_10_back,"app_design"))
        mList.add(DesignSelection(R.drawable.anniversary_card_1_back,"app_design"))
        mList.add(DesignSelection(R.drawable.anniversary_card_2_back,"app_design"))
        mList.add(DesignSelection(R.drawable.anniversary_card_11_back,"app_design"))

        mList.add(DesignSelection(R.drawable.house_warming_card_1_back,"app_design"))
        mList.add(DesignSelection(R.drawable.house_warming_card_5_back,"app_design"))
        mList.add(DesignSelection(R.drawable.house_warming_card_6_back,"app_design"))
        mList.add(DesignSelection(R.drawable.house_warming_card_8_back,"app_design"))
        mList.add(DesignSelection(R.drawable.house_warming_card_9_back,"app_design"))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val intent = Intent(this@UserSelectDesign, PicEditor::class.java)
            val uri = data!!.data
            intent.putExtra("img",uri.toString())
            intent.putExtra("selection_type","upload")
            startActivity(intent)
        }
    }
}