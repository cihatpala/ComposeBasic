package com.example.composebasic.unit3.pathway2.path4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasic.R
import com.example.composebasic.ui.theme.PracticeBuildAGridTheme
import com.example.composebasic.unit3.pathway2.path4.model.Topic
import com.example.composebasic.unit3.pathway2.path4.data.DataSource

class PracticeBuildAGrid : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeBuildAGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FullGrid(Modifier)
                }
            }
        }
    }
}

@Composable
fun FullGrid(modifier: Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .fillMaxWidth()
            .padding(top=10.dp,start = 8.dp, end = 8.dp)
    ) {
        items(DataSource.topics) { topic ->
            GridItem(
                topic,
                modifier.background(color = colorResource(id = R.color.build_grid_background))
            )
        }
    }
}

@Composable
fun GridItem(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(id = topic.image),
                    contentDescription = null,
                    modifier = modifier
                        .width(68.dp)
                        .height(68.dp)
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp,
                            end = 3.dp,
                            bottom = 8.dp
                        )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = topic.idTopic.toString(),
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    PracticeBuildAGridTheme {
        FullGrid(Modifier)
    }
}

