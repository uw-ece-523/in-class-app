package edu.uw.ee523.rouxbe

data class ToDo(var title:String = "A Title",
                var desc: String = "Do this thing really well.",
                var isDone: Boolean = false,
                var importance: Int = 0,
                var tags: Array<String> = emptyArray())
