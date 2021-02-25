package com.example.androiddevchallenge.ui.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.Gender

@Composable
fun displayGender(gender: Gender): String {
    return when (gender) {
        Gender.MALE -> stringResource(id = R.string.gender_n, stringResource(id = R.string.male))
        Gender.FEMALE -> stringResource(
            id = R.string.gender_n,
            stringResource(id = R.string.female)
        )
    }
}

object Routes {
    const val PUPPY_LIST_SCREEN = "puppyList"
    const val PUPPY_DETAILS_SCREEN = "puppyDetails"
}