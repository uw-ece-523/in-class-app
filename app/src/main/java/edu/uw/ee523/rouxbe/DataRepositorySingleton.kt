package edu.uw.ee523.rouxbe

import android.graphics.Bitmap

object DataRepositorySingleton {

    var dataToDo: ToDo = ToDo(title="Write Code")

    lateinit var myCapturedImage: Bitmap
}