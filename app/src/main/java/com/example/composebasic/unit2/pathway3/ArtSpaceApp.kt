package com.example.composebasic.unit2.pathway3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasic.R
import com.example.composebasic.ui.theme.ArtSpaceAppTheme

class ArtSpaceApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    val startAndEndPadding = 20.dp
    Column(
        modifier = modifier
            .fillMaxSize(100f)
            .background(colorResource(id = R.color.white)),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = modifier
                .weight(75f)
                .padding(startAndEndPadding)
                .background(color = colorResource(id = R.color.white))
                .shadow(3.dp, RoundedCornerShape(3.dp))
        ) {
            CustomArtImageArea(modifier, R.drawable.water_lilies)
        }

        Column(
            modifier = modifier
                .weight(20f)
                .padding(
                    start = startAndEndPadding,
                    end = startAndEndPadding, top = 10.dp, bottom = 30.dp
                ),
        ) {
            CustomArtDescriptionArea(
                modifier,
                textSourceArt = R.string.art_water_lilies,
                textSourceArtist = R.string.artist_monet,
                textSourceYear = R.string.art_water_lilies_year,
            )
        }
        Row(
            modifier = modifier
                .padding(
                    start = startAndEndPadding,
                    end = startAndEndPadding, bottom = 20.dp
                )
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomArtButton(modifier, R.string.art_previous)
            CustomArtButton(modifier, R.string.art_next)
        }
    }
}

@Composable
fun CustomArtImageArea(modifier: Modifier, imageSource: Int) {
    Image(
        modifier = modifier
            .padding(30.dp)
            .size(500.dp)
            .clip(RoundedCornerShape(10.dp)),
        painter = painterResource(imageSource),
        contentDescription = null
    )
}

@Composable
fun CustomArtDescriptionArea(
    modifier: Modifier,
    textSourceArt: Int,
    textSourceArtist: Int,
    textSourceYear: Int
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.art_description_background)),

        ) {
        Text(
            text = stringResource(id = textSourceArt),
            modifier = modifier.padding(
                top = 10.dp,
                bottom = 10.dp,
                start = 30.dp,
                end = 30.dp
            )
        )
        Row() {
            Text(
                text = stringResource(id = textSourceArtist),
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(bottom = 10.dp, start = 30.dp)
            )
            Text(
                text = "(" + stringResource(id = textSourceYear) + ")",
                modifier = modifier.padding(end = 30.dp)
            )
        }
    }
}

@Composable
fun CustomArtButton(modifier: Modifier, textSource: Int) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.art_button_background),//buton rengi
            contentColor = colorResource(id = R.color.white) //yazı rengi
        ),
        onClick = {
            //TODO
        }, modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .size(width = 110.dp, height = 42.dp)
    ) {
        Text(stringResource(textSource))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}