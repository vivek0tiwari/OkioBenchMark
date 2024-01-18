package com.example.okiobenchmark.android

import android.app.AlertDialog
import android.content.Context
import android.location.Location
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.okiobenchmark.Greeting
import kotlinx.coroutines.*
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.Future

class MainActivity : ComponentActivity() {
    var alertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView("", alertDialog, applicationContext)
                }
            }
        }



    }

}

suspend fun startOkioFileWrite(context: Context) {
     GlobalScope.launch(Dispatchers.IO) {

     }
     withContext(Dispatchers.IO){
         Greeting().greet(File(context.filesDir, "").path)
     }
}
@Composable
fun GreetingView(text: String, alertDialog: AlertDialog?, context: Context) {
    val coroutineScope = rememberCoroutineScope()
    val startOkioFileWriteCoroute: () -> Unit = {
        coroutineScope.launch {
            startOkioFileWrite(context)
        }
    }

    Button(onClick = { startOkioFileWriteCoroute() }, modifier= Modifier.height(64.dp)) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Start")
    }
}

