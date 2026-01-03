package com.oguzhanaslann.pagercompose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PagerItem(
    page: Int,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(Unit) {
        Log.e("TAG", "PagerItem: creation ${System.currentTimeMillis()}")
    }

    Box(
        modifier = modifier
            .background(
                listOf(
                    Color.Green,
                    Color.Yellow,
                    Color.Magenta,
                    Color.Cyan,
                    Color.Black,
                    Color.Gray,
                    Color.Red,
                    Color.Blue,
                    Color.DarkGray,
                    Color.LightGray
                ).get(page)
                    .copy(alpha = 0.75f)
            ),
    ) {
        // Our page content
        Text(
            text = "Page: $page",
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}