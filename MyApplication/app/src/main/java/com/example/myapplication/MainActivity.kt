package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        val myButton = findViewById<Button>(R.id.button1)
//        myButton.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }
    }
}

//class Car{
//    var brand: String ="Gen"
//    var speed: Int =0
//    fun accelerate(){
//        speed+=10e
//        println("Accerating . Current speed is $speed km/h")
//    }
//}
//fun main(){
//    val myCar= Car()
//    myCar.brand="Tesle"
//    myCar.accelerate()
//    myCar.accelerate()
//}
