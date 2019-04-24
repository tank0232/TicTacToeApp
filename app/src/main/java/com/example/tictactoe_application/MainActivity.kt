package com.example.tictactoe_application

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buClick(view: View){
        val buSelected = view as Button
        var cellID = 0
        when(buSelected.id){
            R.id.bu1 -> cellID=1
            R.id.bu2 -> cellID=2
            R.id.bu3 -> cellID=3
            R.id.bu4 -> cellID=4
            R.id.bu5 -> cellID=5
            R.id.bu6 -> cellID=6
            R.id.bu7 -> cellID=7
            R.id.bu8 -> cellID=8
            R.id.bu9 -> cellID=9
        }

        //Toast.makeText(this,"ID: "+ cellID, Toast.LENGTH_LONG).show()
        try {
            PlayGame(cellID, buSelected)
        }
        catch(e:Exception)
        {
            
        }
    }

    var Player1=ArrayList<Int>()
    var Player2=ArrayList<Int>()
    var ActivePlayer=1

    fun PlayGame(cellID:Int, buSelected:Button){

        if(ActivePlayer==1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.blue)
            Player1.add(cellID)
            ActivePlayer=2
            AutoPlay()
        }else
        {
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.green)
            Player2.add(cellID)
            ActivePlayer=1
        }

        buSelected.isEnabled=false
        CheckWinner()
    }

    fun CheckWinner(){
        var winner = -1

        //row 1

        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            winner = 1
        }
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            winner = 2
        }
        //row 2

        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            winner = 1
        }
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            winner = 2
        }

        //row 3

        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            winner = 1
        }
        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            winner = 2
        }

        //column 1

        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            winner = 1
        }
        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            winner = 2
        }
        //column 2

        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            winner = 1
        }
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            winner = 2
        }

        //column 3

        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            winner = 1
        }
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            winner = 2
        }

        //cross

        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
            winner = 1
        }
        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
            winner = 2
        }
        if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
            winner = 1
        }
        if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
            winner = 2
        }

        if(winner != - 1){
            if(winner==1 )
            {
                Toast.makeText(this,"Player One win the Game", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"Player Two win the Game", Toast.LENGTH_LONG).show()

            }
        }

    }

    fun AutoPlay(){
        var emptyCells=ArrayList<Int>()
        for(cellID in 1..9)
        {
            if(!(Player1.contains(cellID)||Player2.contains(cellID)))
            {
                emptyCells.add(cellID)
            }
        }

        var r= Random()
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellID= emptyCells.get(randIndex)

        var buSelected:Button?
        when(cellID){
            1-> buSelected=bu1
            2-> buSelected=bu2
            3-> buSelected=bu3
            4-> buSelected=bu4
            5-> buSelected=bu5
            6-> buSelected=bu6
            7-> buSelected=bu7
            8-> buSelected=bu8
            9-> buSelected=bu9
            else->{
                buSelected=bu1
            }

        }

        PlayGame(cellID,buSelected)
    }
}
