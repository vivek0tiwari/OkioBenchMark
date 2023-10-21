package com.example.okiobenchmark.android

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.okiobenchmark.FileAppender
import com.example.okiobenchmark.Greeting
import java.io.File

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
                    GreetingView(Greeting().greet(), alertDialog, applicationContext)
                }
            }
        }

        createDialog()
    }
    fun createDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Exit App")
        alertDialogBuilder.setMessage("Are you sure you want to exit?")
        alertDialogBuilder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
            finish()
        }
        alertDialogBuilder.setNegativeButton("Cancel", { dialogInterface: DialogInterface, i: Int -> })
        alertDialog = alertDialogBuilder.create()
    }
}

@Composable
fun GreetingView(text: String, alertDialog: AlertDialog?, context: Context) {
    Button(onClick = { FileAppender.write2mbData(File(context.filesDir, "okio.txt").path,File(context.filesDir, "okio2MB.txt").path ) }, modifier= Modifier.height(64.dp)) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Start")
    }
}

