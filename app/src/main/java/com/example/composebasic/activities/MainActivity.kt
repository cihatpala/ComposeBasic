package com.example.composebasic.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.R
import com.example.composebasic.ui.theme.HappyBirtdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirtdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirtdayImage(stringResource(R.string.happy_birdday, "Y"), "- From X")
                }
            }
        }
    }
}

@Composable
fun BirtdayImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.birtday)
    Box(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.birtday_image),
            contentScale = ContentScale.Crop,
            alpha = 0.4F,
            modifier = Modifier.fillMaxSize()
        )
        GreetingText(
            message, from,
            modifier = modifier.align(Alignment.Center)
        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirtdayImagePreview() {
    BirtdayImage(stringResource(R.string.happy_birdday, "Y"), "- From X")
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier //Yukardan gelen modifier ile yapınca ezilmiyor.
                .align(alignment = Alignment.End)
                .padding(top = 16.dp)
        )
    }
}

@Composable
fun GreetingTextDouble(modifier: Modifier = Modifier) {
    Column {
        GreetingText("Happy Birtday Y", "- From X")
        GreetingText("Happy Birtday X", "- From Y")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirtdayCardPreview() {
    HappyBirtdayTheme {
        GreetingText("Happy Birthday Sam!", "- From Cihat")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirtdayCardDoublePreview() {
    HappyBirtdayTheme {
        GreetingTextDouble()
    }
}