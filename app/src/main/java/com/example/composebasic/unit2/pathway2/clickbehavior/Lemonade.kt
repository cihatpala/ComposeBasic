package com.example.composebasic.unit2.pathway2.clickbehavior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.R
import com.example.composebasic.ui.theme.LemonadeTheme

class Lemonade : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeDesign(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun LemonadeDesign(modifier: Modifier = Modifier) {
    var imageId by remember { mutableStateOf(R.drawable.lemon_tree) }
    var contentDescriptionId by remember { mutableStateOf(R.string.lemon_tree) }
    var selectionImageDescription by remember { mutableStateOf(R.string.select_lemon) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = stringResource(id = contentDescriptionId),
            modifier = modifier
                .background(color = colorResource(id = R.color.business_background))
                .size(300.dp)
                .clickable {
                    imageId = when (imageId) {
                        R.drawable.lemon_tree -> R.drawable.lemon_squeeze
                        R.drawable.lemon_squeeze -> R.drawable.lemon_drink
                        R.drawable.lemon_drink -> R.drawable.lemon_restart
                        R.drawable.lemon_restart -> R.drawable.lemon_tree
                        else -> R.drawable.lemon_tree
                    }

                    contentDescriptionId = when (imageId) {
                        R.drawable.lemon_tree -> R.string.lemon_tree
                        R.drawable.lemon_squeeze -> R.string.lemon
                        R.drawable.lemon_drink -> R.string.glass_of_lemonade
                        R.drawable.lemon_restart -> R.string.empty_class
                        else -> R.drawable.lemon_tree
                    }

                    selectionImageDescription = when (imageId) {
                        R.drawable.lemon_tree -> R.string.select_lemon
                        R.drawable.lemon_squeeze -> R.string.squeeze_lemon
                        R.drawable.lemon_drink -> R.string.drink_lemonade
                        R.drawable.lemon_restart -> R.string.empty_clas_start_again
                        else -> R.drawable.lemon_tree
                    }
                }
        )
        Text(
            text = stringResource(id = selectionImageDescription),
            Modifier
                .padding(top = 16.dp),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeDesignPreview() {
    LemonadeDesign(
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .wrapContentSize(Alignment.Center)
    )
}