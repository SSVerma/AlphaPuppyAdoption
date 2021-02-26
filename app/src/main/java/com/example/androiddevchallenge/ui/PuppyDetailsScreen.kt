/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.core.displayGender
import com.example.androiddevchallenge.ui.data.Puppy

@Composable
fun PuppyDetailsScreen(puppy: Puppy, onBackPressed: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(elevation = 0.dp, backgroundColor = MaterialTheme.colors.primaryVariant) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = rememberRipple(bounded = false)
                        ) {
                            onBackPressed()
                        }
                        .padding(8.dp)
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.background(color = MaterialTheme.colors.primaryVariant)
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                PuppyImage(imageUrl = puppy.imageUrl, modifier = Modifier.wrapContentWidth())
            }
            Column(
                modifier = Modifier.background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
            ) {
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = puppy.nickName,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = displayGender(gender = puppy.gender),
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(12.dp))
                Characteristics(puppy)
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = stringResource(R.string.description),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = stringResource(R.string.doggo_common_description),
                    style = MaterialTheme.typography.body1.copy(lineHeight = 24.sp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                FloatingActionButton(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(16.dp),
                    onClick = {
                        //
                    }
                ) {
                    Text(
                        text = stringResource(R.string.adopt),
                        modifier = Modifier.padding(horizontal = 80.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Characteristics(puppy: Puppy) {
    Row(modifier = Modifier.horizontalScroll(state = rememberScrollState())) {
        CharacteristicChip(text = stringResource(id = R.string.age_n, puppy.ageInMonth.toString()))
        CharacteristicChip(
            text = stringResource(
                id = R.string.length_n,
                puppy.lengthInFeet.toString()
            )
        )
        CharacteristicChip(text = stringResource(id = R.string.color_n, puppy.color))
    }
}

@Composable
private fun CharacteristicChip(text: String) {
    Surface(
        modifier = Modifier.padding(horizontal = 12.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
            style = MaterialTheme.typography.caption
        )
    }
}
