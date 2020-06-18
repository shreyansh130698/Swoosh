package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    //to verify that user can not select all of the Leagues - Men, Women and Coed
    fun onMensClicked(view: View){
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        selectedLeague = "womens"
    }

    fun onCoedClicked(view: View){
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        selectedLeague = "co-ed"
    }

    fun leagueNextClicked(view: View){               // leagueNextClicked declared as onClick in attributes
        if(selectedLeague != ""){                   //to verify that user can not click on NEXT button without selecting League
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)    //data to be sent to next Activity (Skill Activity)
            startActivity(skillActivity)
        }
        else
            Toast.makeText(this,"Please select a League",Toast.LENGTH_SHORT).show()
    }
}
