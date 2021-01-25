package com.senix22.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.senix22.firstproject.adapters.WinnersAdapter
import com.senix22.firstproject.objects.WinnersStorage
import kotlinx.android.synthetic.main.activity_winner_list.*

class WinnerList : AppCompatActivity() {
    private var TAG = "WinnerList"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner_list)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        newGame()
        val adapter = WinnersAdapter(WinnersStorage.getList())
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
        sortbyscore.setOnClickListener {
            val sortedAdapter = WinnersAdapter(WinnersStorage.getSortedList())
            recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            recyclerView.adapter = sortedAdapter
        }
        clearList.setOnClickListener {

            val clearAdapter = WinnersAdapter(WinnersStorage.clearListOfWinners())
            recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            recyclerView.adapter = clearAdapter
        }
        shareText.setOnClickListener {
            if (WinnersStorage.getList().isEmpty()) {
                Toast.makeText(baseContext, "You can`t share empty list", Toast.LENGTH_SHORT).show()
            } else {
                val s = WinnersStorage.getList().toString()
                val shareIntent = Intent()
                shareIntent.apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, s)
                    putExtra(Intent.EXTRA_SUBJECT, "subject here")
                }
                startActivity(Intent.createChooser(shareIntent, "share text"))
                Toast.makeText(baseContext, s, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun newGame() {
        newgame.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}