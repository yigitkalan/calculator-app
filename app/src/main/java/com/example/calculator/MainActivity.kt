package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    var operationSelected = false
    var operator = ""
    var oldNumber = ""

    fun number(v : View) {
        var button = v as Button
        var textValue : String = bind.result.text.toString()

        when(button.id) {
            bind.zero.id  -> {textValue += "0"}
            bind.one.id  -> {textValue += "1"}
            bind.two.id  -> {textValue += "2"}
            bind.three.id  -> {textValue += "3"}
            bind.four.id  -> {textValue += "4"}
            bind.five.id  -> {textValue += "5"}
            bind.six.id  -> {textValue += "6"}
            bind.seven.id  -> {textValue += "7"}
            bind.eight.id  -> {textValue += "8"}
            bind.nine.id  -> {textValue += "9"}
        }
        bind.result.text = textValue

        if(operationSelected)
            operationSelected = false
    }



    fun operation(v : View){
        var button = v as Button
        var textValue : String = bind.result.text.toString()

        when(button.id) {
            bind.divide.id -> operator = "/"
            bind.plus.id -> operator = "+"
            bind.minus.id -> operator = "-"
            bind.multiply.id -> operator = "*"
        }

        if(!operationSelected) {
            textValue += operator
        }
        else {
            textValue = textValue.substring(0,textValue.length-1)
            textValue += operator
        }
        operationSelected = true
        bind.result.text = textValue
    }

    fun delete(v : View) {
        bind.result.text = ""
        operationSelected = false
    }
}