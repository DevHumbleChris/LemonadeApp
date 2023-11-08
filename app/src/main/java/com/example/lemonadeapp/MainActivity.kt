package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun MakeLemonade(modifier: Modifier = Modifier) {
    var clickedStep by remember {
        mutableStateOf(1)
    }

    var description by remember {
        mutableStateOf("")
    }

    var imageResource by remember {
        mutableStateOf(R.drawable.lemon_tree)
    }

    when (clickedStep) {
        2 -> {
            imageResource = R.drawable.lemon_squeeze
            description = "Keep tapping the lemon to squeeze it."
        }
        3 -> {
            imageResource = R.drawable.lemon_drink
            description = "Tap the lemonade to drink it."
        }
        4 -> {
            imageResource = R.drawable.lemon_restart
            description = "Tap the empty glass to start again."
        }
        else -> {
            imageResource = R.drawable.lemon_tree
            description = "Tap the lemon tree to select a lemon."
        }
    }
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (clickedStep >= 4) {
                Image(
                    contentDescription = null,
                    painter = painterResource(id = imageResource),
                    modifier = modifier.clickable {
                        clickedStep = 1
                    }
                )
            } else {
                Image(
                    contentDescription = null,
                    painter = painterResource(id = imageResource),
                    modifier = modifier.clickable {
                        clickedStep += 1
                    }
                )
            }
            Spacer(modifier = modifier.height(10.dp))
            Text(text = description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    MakeLemonade()
}