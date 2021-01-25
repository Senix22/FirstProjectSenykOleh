package com.senix22.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.senix22.firstproject.objects.Constants
import kotlinx.android.synthetic.main.two_teams.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_teams)
        startBtn.setOnClickListener {
            if (enter_first_team.text.toString().isEmpty() && enter_first_team.text.toString()
                    .equals("")
            ) {
                Toast.makeText(this@MainActivity, "Enter first team!", Toast.LENGTH_LONG).show()
            } else if (enter_second_team.text.toString()
                    .isEmpty() && enter_second_team.text.toString().equals("")
            ) {
                Toast.makeText(this@MainActivity, "Enter second team!", Toast.LENGTH_LONG).show()
            } else if (enter_first_team.text.toString().equals(enter_second_team.text.toString())) {
                Toast.makeText(this@MainActivity, "Name can`t be the same", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this@MainActivity, ScoreScreen::class.java)
                intent.putExtra(Constants.FIRST_TEAM_NAME, enter_first_team.text.toString())
                intent.putExtra(Constants.SECOND_TEAM_NAME, enter_second_team.text.toString())
                startActivity(intent)
            }
        }
    }

}