package com.tapbi.demojetpackcompose

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tapbi.demojetpackcompose.ui.theme.DemoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    
    private val TAG = "MainActivity"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ", )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ", )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ", )
    }
    
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Column {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "icon app",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .clickable(onClick = {
                        Toast
                            .makeText(context, "demo click", Toast.LENGTH_SHORT)
                            .show()

                    })
            )
            Column() {
                Text(text = "Hello $name!")
                Text(text = "My Name is: $name!")
            }
        }
        Text(text = "Click go to Native Ui", modifier = Modifier.clickable {
            val intent = Intent(context, NativeUiActivity::class.java)
            context.startActivity(intent)
        })
    }
    

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoJetpackComposeTheme {
        Greeting("Android")
    }
}