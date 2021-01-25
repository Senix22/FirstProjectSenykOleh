package com.senix22.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.senix22.firstproject.objects.Constants
import kotlinx.android.synthetic.main.activity_winner_screen.*

class WinnerScreen : AppCompatActivity() {
    private var firstTeam: String? = null
    private var secondTeam: String? = null
    private var Tag = "WinnerList"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner_screen)
        getWinner()
        winners_list.setOnClickListener {
            val intent = Intent(this@WinnerScreen, WinnerList::class.java)
            startActivity(intent)
        }
    }

    fun getWinner() {
        firstTeam = intent.getStringExtra(Constants.FIRST_TEAM_NAME)
        secondTeam = intent.getStringExtra(Constants.SECOND_TEAM_NAME)
        if (firstTeam.equals(null)) {
            winner_screen.text = "Won : $secondTeam"
        } else {
            winner_screen.text = "Won : $firstTeam"
        }
    }
}