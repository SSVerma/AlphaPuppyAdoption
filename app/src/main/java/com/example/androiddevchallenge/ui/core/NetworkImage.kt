package com.example.androiddevchallenge.ui.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun NetworkImage(imageUrl: String, modifier: Modifier = Modifier) {
    GlideImage(
        data = imageUrl,
        contentDescription = "Image",
        fadeIn = true,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}