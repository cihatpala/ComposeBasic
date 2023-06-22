package com.example.composebasic.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.R
import com.example.composebasic.ui.theme.LearnTogetherTheme


/**
Set the image to fill the entire screen's width.
Set the first Text composable to a 24sp font size and 16dp padding (start, end, bottom, and top).
Set the second Text composable to a default font size, 16dp padding(start and end), and Justify text align.
Set the third Text composable to a default font size, 16dp padding (start, end, bottom, and top), and Justify text align.
 */

class LearnTogether : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnTogetherAreas(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Composable
fun LearnTogetherAreas(modifier: Modifier = Modifier) {
    Column() {
        Image(
            //Set the image to fill the entire screen's width.
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = stringResource(id = R.string.learn_together_header_image),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            //Set the first Text composable to a 24sp font size and 16dp padding (start, end, bottom, and top).
            text = stringResource(id = R.string.learn_together_head_text),
            fontSize = 24.sp,
            modifier = modifier //Yukardan gelen modifierdaki padding uygulandı
        )
        Text(
            //Set the second Text composable to a default font size, 16dp padding(start and end), and Justify text align.
            text = stringResource(id = R.string.learn_together_introduction_text),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            //Set the third Text composable to a default font size, 16dp padding (start, end, bottom, and top), and Justify text align.
            text = stringResource(id = R.string.learn_together_detail_text),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        //For text1 (learn_together_head_text) only
        LearnTogetherAreas(modifier = Modifier.padding(16.dp))
    }
}