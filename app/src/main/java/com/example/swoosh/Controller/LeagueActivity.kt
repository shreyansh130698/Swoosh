package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    //var selectedLeague = ""
    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {                 //if the user rotates the screen on this page, instance (activity) will be restored to default(blank)
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){                                // it has been rotated
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    //to verify that user can not select all of the Leagues - Men, Women and Coed
    fun onMensClicked(view: View){
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        //selectedLeague = "mens"
        player.league = "mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View){
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextClicked(view: View){               // leagueNextClicked declared as onClick in attributes
        if(player.league != ""){                   //to verify that user can not click on NEXT button without selecting League
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)    //data to be sent to next Activity (Skill Activity)
            startActivity(skillActivity)
        }
        else
            Toast.makeText(this,"Please select a League",Toast.LENGTH_SHORT).show()
    }
}
