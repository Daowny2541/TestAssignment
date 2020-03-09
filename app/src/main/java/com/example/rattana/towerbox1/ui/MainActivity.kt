package com.example.rattana.towerbox1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rattana.towerbox1.R
import com.example.rattana.towerbox1.adapter.ItemBoxAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private var personImages= ArrayList(
        arrayListOf(
            R.drawable.bg_box_blue,
            R.drawable.bg_box_pink,
            R.drawable.bg_box_blue,
            R.drawable.bg_box_pink,
            R.drawable.bg_box_blue,
            R.drawable.bg_box_pink,
            R.drawable.bg_box_blue,
            R.drawable.bg_box_pink
        )
    )

    //private var personImages = ArrayList<Int>()

    lateinit var mAdapter: ItemBoxAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*for (num in 0..19){
            personImages.add(num)
        }*/

        setAdapter()
        setOnRefresh()
        setOnClick()

    }

    private fun setOnRefresh() {
        rootRefresh.setOnRefreshListener {
            rootRefresh.isRefreshing = false
            shuffleItems()
        }
    }
    private fun shuffleItems() {
        // shuffle the ArrayList's items and set the adapter
        personImages.shuffle(Random(System.currentTimeMillis()))
        // call the constructor of CustomAdapter to send the reference and data to Adapter

        setAdapter()
    }

    /*private fun nextColor() {
        val random: Random = Random()
        val value = random.nextInt(20)
    }*/

    private fun setOnClick() {
        btnClickPink.setOnClickListener {
            removeItemBoxPink()
        }
        btnClickBlue.setOnClickListener {
            removeItemBoxBlue()
        }
    }

    private fun removeItemBoxPink() {
        val removeIndex = R.drawable.bg_box_pink
        personImages.remove(removeIndex)
        mAdapter.notifyItemRemoved(removeIndex)
    }

    private fun removeItemBoxBlue() {
        val removeIndexBlue = R.drawable.bg_box_blue
        personImages.remove(removeIndexBlue)
        mAdapter.notifyItemRemoved(removeIndexBlue)
    }

    private fun setAdapter() {
        mAdapter = ItemBoxAdapter(this,personImages)
        val layoutManager = LinearLayoutManager(this)
        rcvItemBox.layoutManager = layoutManager
        rcvItemBox.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }


}
