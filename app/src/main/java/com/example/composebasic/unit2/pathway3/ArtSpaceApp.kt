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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val artDataList: ArrayList<ArtModel> = ArrayList()
    artDataList.add(
        ArtModel(
            "Gezinti (La Promenade)",
            "Claude Monet",
            R.drawable.promenade,
            "1875"
        )
    )
    artDataList.add(
        ArtModel(
            "Mona Lisa",
            "Leonardo di ser Piero da Vinci",
            R.drawable.mona_lisa,
            "1503"
        )
    )
    artDataList.add(
        ArtModel(
            "Nilüferler (Les Nymphéas, Water Lilies)",
            "Claude Monet",
            R.drawable.water_lilies,
            "1895 – 1926"
        )
    )
    var index by remember { mutableStateOf(0) }
    println("artDataList: ${artDataList.size}")
    println("index:  $index")

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
                .shadow(3.dp, RoundedCornerShape(3.dp)),
            contentAlignment = Alignment.Center
        ) {
            CustomArtImageArea(modifier, artDataList.get(index).artImageSource)
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
                artName = artDataList.get(index).artName,
                artistName = artDataList.get(index).artistName,
                artYear = artDataList.get(index).artYear,
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
            println("Before Button index: $index ")
            CustomArtButton(modifier, R.string.art_previous, onClick = {
                println("1 After Button index: $index ")
                if ((index - 1 != artDataList.size - 1) && index != 0) {
                    index -= 1
                } else if (index == 0) { //İlk elemansa geri butonu geriye doğru sararak çalışsın.
                    index = artDataList.size - 1
                } else index = 0
            })
            CustomArtButton(modifier, R.string.art_next, onClick = {
                println("2 After Button index: $index ")
                if (index != artDataList.size - 1) index += 1
                else index = 0
            })
        }
    }
}

@Composable
fun CustomArtImageArea(modifier: Modifier, imageSource: Int) {
    Image(
        modifier = modifier
            .padding(20.dp)
            .size(500.dp)
            .clip(RoundedCornerShape(10.dp)),
        painter = painterResource(imageSource),
        contentDescription = null
    )
}

@Composable
fun CustomArtDescriptionArea(
    modifier: Modifier,
    artName: String,
    artistName: String,
    artYear: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.art_description_background)),

        ) {
        Text(
            text = artName,
            modifier = modifier.padding(
                top = 10.dp,
                bottom = 10.dp,
                start = 30.dp,
                end = 30.dp
            )
        )
        Row() {
            Text(
                text = artistName,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(bottom = 10.dp, start = 30.dp)
            )
            Text(
                text = "($artYear)",
                modifier = modifier.padding(end = 30.dp)
            )
        }
    }
}

@Composable
fun CustomArtButton(
    modifier: Modifier,
    textSource: Int,
    onClick: () -> Unit,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.art_button_background),//buton rengi
            contentColor = colorResource(id = R.color.white) //yazı rengi
        ),
        onClick = onClick,
        modifier = modifier
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