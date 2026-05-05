package rs.ac.ftn.todov1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import rs.ac.ftn.todov1.ui.ToDoApp
import rs.ac.ftn.todov1.ui.theme.ToDoV1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoV1Theme {
                ToDoApp()
            }
        }
    }
}

