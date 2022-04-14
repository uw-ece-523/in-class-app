package edu.uw.ee523.rouxbe

import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {

    val todoTitle: String = DataRepositorySingleton.dataToDo.title
    val todoDesc: String = DataRepositorySingleton.dataToDo.desc

}