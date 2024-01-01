package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buClick(view:View){
        val buSelect: Button = view as Button


       var cellId = 0
        when(buSelect.id){
            R.id.bu1-> cellId = 1
            R.id.bu2-> cellId = 2
            R.id.bu3-> cellId = 3
            R.id.bu4-> cellId = 4
            R.id.bu5-> cellId = 5
            R.id.bu6-> cellId = 6
            R.id.bu7-> cellId = 7
            R.id.bu8-> cellId = 8
            R.id.bu9-> cellId = 9
        }
//        Log.d("buClick:", buSelect.id.toString())
//        Log.d("buClick:cellId", cellId.toString())
        playGame(cellId, buSelect)

    }
    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId:Int, buSelect:Button){
        if(activePlayer == 1){
            buSelect.text = "X"
            buSelect.setBackgroundResource(R.color.red)

            player1.add((cellId))
            activePlayer = 2
        }else{
            buSelect.text = "O"
            buSelect.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
            activePlayer = 1
        }
        buSelect.isEnabled = false
checkWinner()
    }
    fun checkWinner() {
        var winer = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }
        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }
        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }
     //   column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }
        // colum 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }
        //  colum 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }
        if (winer == 1){
            Toast.makeText(this,"Player 1 Win the game", Toast.LENGTH_LONG).show()
        }else if(winer == 2){
            Toast.makeText(this,"Player 2 win the game" , Toast.LENGTH_LONG).show()
        }
    }
}