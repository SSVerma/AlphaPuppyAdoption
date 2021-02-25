package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.core.NetworkImage
import com.example.androiddevchallenge.ui.core.displayGender
import com.example.androiddevchallenge.ui.data.Puppy

@Composable
fun PuppyListScreen(puppies: List<Puppy>, onItemClicked: (puppy: Puppy) -> Unit) {
    Column(modifier = Modifier.background(color = MaterialTheme.colors.primaryVariant)) {
        WelcomeSection()
        PuppyList(
            puppies = puppies,
            modifier = Modifier.background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ),
            onItemClicked = {
                onItemClicked(it)
            }
        )
    }
}

@Composable
fun WelcomeSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = 16.dp, vertical = 32.dp)) {
        Row {
            Text(
                text = stringResource(R.string.hello_with_comma),
                color = contentColorFor(backgroundColor = MaterialTheme.colors.primaryVariant)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = stringResource(R.string.me),
                style = MaterialTheme.typography.subtitle1.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = contentColorFor(backgroundColor = MaterialTheme.colors.primaryVariant)
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = stringResource(
                R.string.welcome_tag_line,
                stringResource(id = R.string.app_name)
            ),
            color = contentColorFor(backgroundColor = MaterialTheme.colors.primaryVariant).copy(
                alpha = 0.76f
            ),
            style = MaterialTheme.typography.subtitle1.copy(
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun PuppyList(
    puppies: List<Puppy>,
    onItemClicked: (puppy: Puppy) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp),
        content = {
            items(puppies) { puppy ->
                PuppyItem(puppy = puppy, modifier = Modifier.clickable {
                    onItemClicked(puppy)
                })
                Divider()
            }
        }
    )
}

@Composable
fun PuppyItem(puppy: Puppy, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        PuppyImage(imageUrl = puppy.imageUrl)
        Spacer(modifier = Modifier.size(16.dp))
        PuppyInfo(puppy = puppy)
    }
}

@Composable
fun PuppyImage(imageUrl: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(120.dp)
            .background(color = Color.Gray, shape = RoundedCornerShape(size = 16.dp))
            .clip(shape = RoundedCornerShape(size = 16.dp))
    ) {
        NetworkImage(imageUrl = imageUrl)
    }
}

@Composable
fun PuppyInfo(puppy: Puppy) {
    Column {
        Text(text = puppy.name, style = MaterialTheme.typography.h6)
        Text(text = puppy.nickName, style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = stringResource(
                id = R.string.puppy_body_info_n,
                puppy.ageInMonth.toString(),
                puppy.lengthInFeet.toString()
            ),
            style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = displayGender(gender = puppy.gender),
            style = MaterialTheme.typography.subtitle2
        )
        Spacer(modifier = Modifier.size(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Location Icon")
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = stringResource(id = R.string.miles_n, puppy.distanceInMiles.toString()),
                style = MaterialTheme.typography.caption
            )
        }
    }
}