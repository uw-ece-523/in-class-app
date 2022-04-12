package edu.uw.ee523.rouxbe
import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat

const val MY_TAG = "CountActivity"

class CountActivity : AppCompatActivity() {
    var cur_count = 0
    lateinit var imageUri: Uri
    val REQUEST_IMAGE_CAPTURE = 42
    val REQUEST_CHOOSE_IMAGE = 47

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

            startCameraIntentForResult(textView)
        }

        // Register the permissions callback, which handles the user's response to the
        // system permissions dialog. Save the return value, an instance of
        // ActivityResultLauncher. You can use either a val, as shown in this snippet,
        // or a lateinit var in your onAttach() or onCreate() method.
        val requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                    Log.i(MY_TAG, "permission is granted ")

                } else {
                    // Explain to the user that the feature is unavailable because the
                    // features requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                    Log.i(MY_TAG, "permission is NOT granted ")
                }
            }

        val canUseCamera = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        )
        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            Log.i(MY_TAG, "I should tell you why I want to use the camera")
        }
        if (canUseCamera == PackageManager.PERMISSION_DENIED) {
            Log.i(MY_TAG,"Don't have permission so going to ask for it")
            requestPermissionLauncher.launch(
                Manifest.permission.CAMERA
            )
        }
//
//        val canUseStorage = ContextCompat.checkSelfPermission(
//            this,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//        )
////
//        if (canUseStorage == PackageManager.PERMISSION_DENIED) {
//            shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//            Log.i(MY_TAG,"Don't have permission so going to ask for it")
//            requestPermissionLauncher.launch(
//                Manifest.permission.WRITE_EXTERNAL_STORAGE
//            )
//        }

    }

    private fun requestCameraPermissions(requestPermissionLauncher: ActivityResultLauncher<String>) {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                Toast.makeText(
                    this,
                    "In order to demonstrate the success scenario we need you to allow access to the permission",
                    Toast.LENGTH_LONG
                ).show()
            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    Manifest.permission.CAMERA
                )
            }
        }
    }

    private fun requestStoragePermissions(requestPermissionLauncher: ActivityResultLauncher<String>) {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
            }
            shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
                // In an educational UI, explain to the user why your app requires this
                // permission for a specific feature to behave as expected. In this UI,
                // include a "cancel" or "no thanks" button that allows the user to
                // continue using your app without granting the permission.
                Log.i(MY_TAG, "do it for me, please")
                Toast.makeText(
                    this,
                    "In order to demonstrate the success scenario we need you to allow access to the permission",
                    Toast.LENGTH_LONG
                ).show()
            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            }
        }
    }

    fun startCameraIntentForResult(view: View) {
        // Clean up last time's image
//        imageUri = null
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureIntent.resolveActivity(packageManager)?.let {
            val values = ContentValues()
            values.put(MediaStore.Images.Media.TITLE, "New Picture")
            values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera")
            imageUri =
                contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)!!
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)

            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
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