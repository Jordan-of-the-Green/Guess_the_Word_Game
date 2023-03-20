package com.st10083222.guessthewordgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // define the variable
    lateinit var btn_Send: Button
    lateinit var et_Name: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_Name = findViewById(R.id.et_Name)
        btn_Send = findViewById(R.id.btn_Send)


        btn_Send.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("name", et_Name.text.toString())

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..1) {
            data.add(ItemsViewModel(R.drawable.human, "ANIMAL SPECIES" + "\n" + "Human" + "\n" + "Eagle" + "\n" + "Lion" + "\n" + "Whale" + "\n" + "Cheetah" + "\n" + "Zebra" + "\n" + "Meercat"))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter




    }
}
