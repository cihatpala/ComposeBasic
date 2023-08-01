package com.example.composebasic.unit3.pathway2.path4.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,val idTopic: Int, @DrawableRes val image: Int
)
