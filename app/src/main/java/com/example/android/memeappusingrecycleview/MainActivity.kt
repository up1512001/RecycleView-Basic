package com.example.android.memeappusingrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MemeItemCLicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager = LinearLayoutManager(this)
        val items = fetchData()
        val adapter : MemeListAdapter = MemeListAdapter(items,this)
        recycleView.adapter = adapter

    }

    private fun fetchData(): ArrayList<String> {
        val items = ArrayList<String>()
        for(i in 0 until 100){
            items.add("Item $i")
        }
        return items
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this,"Item $item Clicked",Toast.LENGTH_SHORT).show()
    }

}