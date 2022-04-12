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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myToDo = ToDo(title="Write Code");




        val button = findViewById<Button>(R.id.button_show_message)
        button.setOnClickListener {
            Log.i("MainActivity", "In the Lambda!")

//            binding.myToDo.title = "Click the button"


//            button.setText("lambda")
//
//            val intent = Intent(this, CountActivity::class.java)
//            intent.apply{
//                putExtra("MESSAGE_TO_SHOW", "Adafruit")
//            }
//
//            startActivity(intent)
        }
//        button.setOnClickListener(View.OnClickListener {
//                view ->
//            Log.i("MainActivity", "with the view")
//            val button:Button = view as Button
//            button.text = "Sparky"
//        })
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