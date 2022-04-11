package edu.uw.ee523.rouxbe

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

data class ToDo @RequiresApi(Build.VERSION_CODES.O) constructor(var title:String = "No title",
                                                                val description: String = "Really?",
                                                                val isCompleted: Boolean = false,
                                                                val dueDate: LocalDateTime =
                                                                    LocalDateTime.now().plusDays(1) )
