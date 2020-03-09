package com.example.rattana.towerbox1.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rattana.towerbox1.R
import kotlinx.android.synthetic.main.random_item_box.view.*
import java.util.*
import kotlin.collections.ArrayList

class ItemBoxAdapter(private val mContext: Context?
                     , private val mBoxList: ArrayList<Int>
) : RecyclerView.Adapter<ItemBoxAdapter.ViewHolder>() {


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        //val imgBox: ImageView = itemLayoutView.imgBox
        val imgBox2: ImageView = itemLayoutView.imgBox2
        //val imgBox2: TextView = itemLayoutView.imgBox2
        //val imgBox3: ImageView = itemLayoutView.imgBox3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.random_item_box, parent , false)
        return ViewHolder(
            itemLayoutView
        )
    }

    override fun getItemCount(): Int = mBoxList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.imgBox.setImageResource(R.drawable.bg_box_diamond)
        holder.imgBox2.setImageResource(mBoxList[position])
        //holder.imgBox2.text = mBoxList[position].toString()
        //holder.imgBox3.setImageResource(mBoxList[position])

    }

}

interface OnClickListener {
    fun onClickListener(view: View, position: Int)
}