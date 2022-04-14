package edu.uw.ee523.rouxbe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.uw.ee523.rouxbe.databinding.ActivityMainBinding

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
//    var mainActivityTodo: ToDo = ToDo(title="Write Code")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)


        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myToDo = DataRepositorySingleton.dataToDo

//        val button = findViewById<Button>(R.id.button_show_message)

        binding.buttonShowMessage.setOnClickListener {
            Log.i(TAG, DataRepositorySingleton.dataToDo.toString())
        }
    }


    fun sayCheese(view: View) {
        Log.i("MainActivity", "Cheeeeeese")
        val button:Button = view as Button
        button.setText("Cheeese")
        button.text = "foo"

        binding?.myToDo?.title = "Click the button"

    }
}