package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Lemonade(modifier = Modifier)
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier){
    Column(){
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.Yellow),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Lemoade",
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
            )
        }

        var currentStep by remember{ mutableStateOf(1)}
        var squeezeCount by remember { mutableStateOf(0) }
        var imageId = when(currentStep){
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        var TextId = when(currentStep){
            1 -> R.string.firstString
            2 -> R.string.secondString
            3 -> R.string.thirdString
            else -> R.string.forthString
        }
        Surface(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .weight(10f)
        ){
            when(currentStep){
                1 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .weight(10f)
                            .fillMaxSize(),
                    ) {
                        Image(painter = painterResource(imageId), contentDescription = currentStep.toString(),
                            modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .clickable {
                                    currentStep = 2
                                    squeezeCount = (2..4).random()
                                }
                        )
                        Text(
                            text = stringResource(TextId)
                        )

                    }
                }
                2 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Image(painter = painterResource(imageId), contentDescription = currentStep.toString(),
                            modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .clickable {
                                    squeezeCount--
                                    if (squeezeCount == 0) {
                                        currentStep = 3
                                    }

                                }
                        )
                        Text(
                            text = stringResource(TextId)
                        )

                    }
                }
                3 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Image(painter = painterResource(imageId), contentDescription = currentStep.toString(),
                            modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .clickable {


                                    currentStep = 4
                                }
                        )
                        Text(
                            text = stringResource(TextId)
                        )

                    }
                }
                else -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Image(painter = painterResource(imageId), contentDescription = currentStep.toString(),
                            modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .clickable {
                                    currentStep = 1
                                }
                        )
                        Text(
                            text = stringResource(TextId)
                        )

                    }
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
       Lemonade()
    }
}