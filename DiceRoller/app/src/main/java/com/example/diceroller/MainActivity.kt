package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var resultText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        val resetButton : Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener {
            reset()
        }

        diceImage = findViewById(R.id.imageView)
        diceImage2 = findViewById(R.id.dice_imageVew_2)
        resultText = findViewById(R.id.result_text)

    }

    private fun reset(){
        diceImage?.setImageResource(R.drawable.empty_dice)
        diceImage2?.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice() {

        val drawableResource1 = getRandomDiceImage()
        val drawableResource2 = getRandomDiceImage()

        diceImage?.setImageResource(drawableResource1.first)
        diceImage2?.setImageResource(drawableResource2.first)

        setTagvalue(image1Value = drawableResource1.second,image2Value = drawableResource2.second)
        validateTag()
    }

    private fun setTagvalue(image1Value : Int, image2Value: Int){
        diceImage?.tag = image1Value
        diceImage2?.tag = image2Value

    }
    private fun validateTag() {

        if (diceImage?.getTag() ==  diceImage2?.getTag()) {
            resultText.setText("pass")
        } else {
            resultText.setText("failed")
        }
    }
    private fun getRandomDiceImage() : Pair<Int, Int> {

        var randomInt = (1..6).random()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        return Pair(drawableResource,randomInt)
    }

}
