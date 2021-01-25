package com.senix22.firstproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.senix22.firstproject.objects.Constants
import com.senix22.firstproject.objects.WinnersStorage
import kotlinx.android.synthetic.main.team_score.*
import kotlinx.android.synthetic.main.two_teams.*
import java.util.concurrent.TimeUnit

class ScoreScreen : AppCompatActivity() {
    private var firstTeam: String? = null
    private var secondTeam: String? = null
    private var teamOneScore = 0
    private var teamTwoScore = 0
    private var isCancelled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_score)
        getNameofTeams()
        incrementScore()
        finishBtn.setOnClickListener {
            when {
                teamOneScore > teamTwoScore -> {
                    val intent = Intent(this@ScoreScreen, WinnerScreen::class.java)
                    intent.putExtra(Constants.FIRST_TEAM_NAME, firstTeam)
                    startActivity(intent)
                    val winner = WinnersData(firstTeam!!, teamOneScore)
                    WinnersStorage.addWinners(winner)
                    WinnersStorage.addSortedWinner(winner)
                    Toast.makeText(baseContext, "$firstTeam won", Toast.LENGTH_SHORT).show()
                }
                teamOneScore < teamTwoScore -> {
                    val intent2 = Intent(this@ScoreScreen, WinnerScreen::class.java)
                    intent2.putExtra(Constants.SECOND_TEAM_NAME, secondTeam)
                    startActivity(intent2)
                    val winner = WinnersData(secondTeam!!, teamTwoScore)
                    WinnersStorage.addWinners(winner)
                    WinnersStorage.addSortedWinner(winner)
                    Toast.makeText(baseContext, "$secondTeam won", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(baseContext, "DRAW", Toast.LENGTH_SHORT).show()
                }
            }
        }
        startTimer.setOnClickListener {
            isCancelled = false
            startTimer()
        }
        resetTimer.setOnClickListener {
            isCancelled = true
            val intent2 = Intent(this@ScoreScreen, MainActivity::class.java)
            startActivity(intent2)

        }
    }

    fun getNameofTeams() {
        firstTeam = intent.getStringExtra(Constants.FIRST_TEAM_NAME)
        secondTeam = intent.getStringExtra(Constants.SECOND_TEAM_NAME)
        first_team_name.text = firstTeam
        second_team_name.text = secondTeam
    }

    fun incrementScore() {
        addPointTeamOne.setOnClickListener {
            teamOneScore++
            team_a_score.text = teamOneScore.toString()
        }
        addPointTeamTwo.setOnClickListener {
            teamTwoScore++
            team_b_score.text = teamTwoScore.toString()
        }

    }

    private fun startTimer() {
        if (enterMinutes.text.toString().isEmpty() && enterMinutes.text.toString()
                .equals("")
        ) {
            Toast.makeText(baseContext, "Enter the time!", Toast.LENGTH_SHORT).show()
        } else {
            val time = enterMinutes.text.toString().toLong() * 1000
            val timer = object : CountDownTimer(time * 60, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    if (isCancelled) {
                        startTimer.isEnabled = true
                        countdownText.text = "Canceled"
                        cancel()
                    } else {
                        startTimer.isEnabled = false
                        countdownText.text =
                            "minutes : ${TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60} seconds :${
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                            }"
                    }
                }


                override fun onFinish() {
                    startTimer.isEnabled = true
                    countdownText.text = "Time is over!"
                }
            }
            timer.start()
        }
    }
}

