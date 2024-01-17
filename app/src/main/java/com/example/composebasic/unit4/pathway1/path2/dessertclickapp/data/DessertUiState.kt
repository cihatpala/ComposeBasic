package com.example.composebasic.unit4.pathway1.path2.dessertclickapp.data

import androidx.annotation.DrawableRes
import com.example.composebasic.unit4.pathway1.path2.dessertclickapp.data.Datasource.dessertList

data class DessertUiState(
    val currentDessertIndex: Int = 0,
    val dessertsSold: Int = 0,
    val revenue: Int = 0,
    val currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    @DrawableRes val currentDessertImageId: Int = dessertList[currentDessertIndex].imageId
)