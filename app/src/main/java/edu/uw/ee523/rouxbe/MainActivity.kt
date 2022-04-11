package edu.uw.ee523.rouxbe

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import edu.uw.ee523.rouxbe.databinding.ActivityMainBinding

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main);
//
//        binding.todo = ToDo("do it!", "or something", false)
        // Use the 'by viewModels()' Kotlin property delegate
        // from the activity-ktx artifact
        val model: ToDoViewModel by viewModels()

//        model.getToDo().observe(this, Observer<ToDo>{
//            todo->binding.textMessage.setBackgroundColor(Color.GREEN)
//        })


        val button = findViewById<Button>(R.id.button_show_message)
        button.setOnClickListener {
            Log.i("MainActivity", "In the Lambda!")
            button.setText("lambda")

            val intent = Intent(this, CountActivity::class.java)
            intent.apply{
                putExtra("MESSAGE_TO_SHOW", "Adafruit")
            }

            startActivity(intent)
        }

        }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }


    fun showNewActivity(button: View) {
        Log.i("MainActivity", "button is clicked")
    }

    fun sayCheese(view: View) {
        Log.i("MainActivity", "Cheeeeeese")
        val button:Button = view as Button
        button.setText("Cheeese")
        button.text = "foo"
    }
}