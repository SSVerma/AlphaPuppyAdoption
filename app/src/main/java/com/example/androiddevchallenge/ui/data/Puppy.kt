package com.example.androiddevchallenge.ui.data

import androidx.compose.ui.graphics.Color

data class Puppy(
    val id: Int,
    val name: String,
    val nickName: String,
    val gender: Gender,
    val ageInMonth: Int,
    val lengthInFeet: Float,
    val distanceInMiles: Int,
    val color: Color,
    val imageUrl: String
)

enum class Gender {
    MALE, FEMALE
}