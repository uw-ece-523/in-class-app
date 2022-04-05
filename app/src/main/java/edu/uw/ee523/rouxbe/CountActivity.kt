package edu.uw.ee523.rouxbe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

const val MY_TAG = "CountActivity"

class CountActivity : AppCompatActivity() {
    var cur_count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(MY_TAG, "onCreate")
        cur_count = 0
        setContentView(R.layout.activity_count)
        val message = intent.getStringExtra("MESSAGE_TO_SHOW")
        val textView = findViewById<TextView>(R.id.textView_message)
        textView.text = message

        val button = findViewById<Button>(R.id.button_add_one)
        button.setOnClickListener {
            cur_count++
            textView.text = cur_count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNT", cur_count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        cur_count = savedInstanceState.getInt("COUNT")
    }

    override fun onStop() {
        super.onStop()
        Log.i(MY_TAG, "onStop")
    }


    override fun onResume() {
        super.onResume()
        Log.i(MY_TAG, "onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.i(MY_TAG, "onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MY_TAG, "onDestroy")
    }

}