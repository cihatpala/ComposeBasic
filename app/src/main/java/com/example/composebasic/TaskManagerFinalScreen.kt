package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.ui.theme.TaskManagerTheme

class TaskManagerFinalScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FinalScreen()
                }
            }
        }
    }
}

@Composable
fun FinalScreen(modifier: Modifier = Modifier) {
    //Center align all of the content vertically and horizontally on the screen.

    Box(modifier = modifier) {
        Row(
            modifier = modifier.align(Alignment.Center),
        ) {
            FinalScreenText(
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }

}

@Composable
fun FinalScreenText(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = "asdasd",
            modifier = modifier
        )
        //Set the first Text composable to a Bold font weight, 24dp padding top, and 8dp padding bottom.
        Text(
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
            textAlign = TextAlign.Right,
            fontWeight = FontWeight.Bold,
            text = stringResource(id = R.string.all_task_completed)
        )
        //Set the second Text composable to a 16sp font size.
        Text(
            modifier = modifier,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.nice_work)
        )
    }
}

@Composable
@Preview(showSystemUi = true, name = "Final Screen Preview")
fun FinalScreenPreview(modifier: Modifier = Modifier) {
    FinalScreen()
}