package edu.uw.ee523.rouxbe

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.time.Month

class ToDoViewModel: ViewModel(){

    private val todo: LiveData<ToDo> =
        MutableLiveData<ToDo>(
            ToDo(title="Sample",
                description = "Something to do",
                isCompleted = false))

    fun getToDo(): LiveData<ToDo> {
        return todo
    }
}