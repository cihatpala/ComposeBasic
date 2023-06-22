package com.example.composebasic.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasic.R
import com.example.composebasic.ui.theme.ComposeQuadrantTheme

class ComposeQuadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantScreen()
                }
            }
        }
    }
}

@Composable
fun QuadrantScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(100f)
    ) {
        //İlk Row Colum'un 100 parçasından 50'sini alsın
        //İlk Row kendi içinde 100 parçaya bölünsün (fillMaxSize(100f) ile yapıldı)
        Row(
            modifier = Modifier
                .fillMaxSize(100f)
                .weight(50f)
        ) {
            Box(
                modifier = Modifier
                    .weight(50f)
                    .background(color = colorResource(id = R.color.quadrant_1))
                    .padding(16.dp)// Metni dikeyde ortala
            ) {
                EachArea(
                    R.string.text_composable,
                    R.string.text_composable_desc
                )
            }
            Box(
                modifier = Modifier
                    .weight(50f)
                    .background(color = colorResource(id = R.color.quadrant_2))
                    .padding(16.dp)// Metni dikeyde ortala
            ) {
                EachArea(
                    R.string.image_composable,
                    R.string.image_composable_desc
                )
            }
        }

        //İkinci Row Colum'un 100 parçasından 50'sini alsın (weight(50f) ile yapıldı)
        //İkinci Row kendi içinde 100 parçaya bölünsün (fillMaxSize(100f) ile yapıldı)
        Row(
            modifier = Modifier
                .fillMaxSize(100f)
                .weight(50f)
        ) {

            Box(
                modifier = Modifier
                    .weight(50f)
                    .background(color = colorResource(id = R.color.quadrant_3))
                    .padding(16.dp)// Metni dikeyde ortala
            ) {
                EachArea(
                    R.string.row_composable,
                    R.string.row_composable_desc
                )
            }
            Box(
                modifier = Modifier
                    .weight(50f)
                    .background(color = colorResource(id = R.color.quadrant_4))
                    .padding(16.dp)// Metni dikeyde ortala
            ) {
                EachArea(
                    R.string.column_composable,
                    R.string.column_composable_desc
                )
            }
        }
    }
}

@Composable
fun EachArea(textHeadId: Int, textDescId: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize() // Metni yatayda ve dikeyde ortala
    ) {
        //Format the first Text composable in bold and set it to a 16dp padding bottom.
        Text(
            text = stringResource(id = textHeadId),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )
        //Set the second Text composable to a Default font size.
        Text(
            text = stringResource(id = textDescId),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showSystemUi = true, name = "Quadrant Screen App")
@Composable
fun QuadrantScreenPreview() {
    QuadrantScreen()
}