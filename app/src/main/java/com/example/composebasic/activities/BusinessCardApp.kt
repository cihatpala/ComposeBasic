package com.example.composebasic.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.R
import com.example.composebasic.ui.theme.BusinessCardAppTheme

class BusinessCardApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardAppAll()
                }
            }
        }
    }
}

@Composable
fun BusinessCardAppAll() {
    Column(
        modifier = Modifier
            .fillMaxWidth(100f)
            .background(colorResource(id = R.color.business_background))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(100f)
                .weight(70f),
            horizontalAlignment = Alignment.CenterHorizontally,//Yatayda ortalıyor
            verticalArrangement = Arrangement.Center//Dikeyde ortalıyor.
        ) {
            PersonNameAndJob()
        }

        Column(
            modifier = Modifier
                .weight(30f)
                .align(Alignment.Start)
        ) {
            Row(
                modifier = Modifier
                    .weight(20f)
                    .padding(start = 100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_task_completed),
                    contentDescription = "Phone Number",
                    modifier = Modifier.padding(9.dp)
                )
                Text(
                    text = "asd",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .weight(20f)
                    .padding(start = 100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_task_completed),
                    contentDescription = "Phone Number",
                    modifier = Modifier.padding(9.dp)
                )
                Text(
                    text = "asd",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .weight(20f)
                    .padding(start = 100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_task_completed),
                    contentDescription = "Phone Number",
                    modifier = Modifier.padding(9.dp)
                )
                Text(
                    text = "asd",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .weight(20f)
                    .padding(start = 100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_task_completed),
                    contentDescription = "Phone Number",
                    modifier = Modifier.padding(9.dp)
                )
                Text(
                    text = "asd",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                )
            }

        }
    }
}

@Composable
fun PersoImageAndInfo(modifier: Modifier = Modifier) {

}

@Composable
fun PersonNameAndJob() {
    Image(
        painter = painterResource(id = R.drawable.ic_task_completed),
        contentDescription = "asd",
        alignment = Alignment.Center,
        modifier = Modifier.padding(start = 120.dp, end = 120.dp)
    )
    Text(
        text = stringResource(id = R.string.person_name),
        fontSize = 34.sp,
        fontWeight = FontWeight.ExtraLight,
        color = colorResource(id = R.color.black)
    )
    Text(
        text = stringResource(id = R.string.person_job),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(id = R.color.green_text_and_logo),
        textAlign = TextAlign.Justify
    )
}

@Preview(showSystemUi = true, name = "Business Card App")
@Composable
fun BusinessCardAppAllPreview() {
    BusinessCardAppAll()
}