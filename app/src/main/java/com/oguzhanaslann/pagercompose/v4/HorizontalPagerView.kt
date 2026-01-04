package com.oguzhanaslann.pagercompose.v4

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.oguzhanaslann.pagercompose.PagerItem

@Composable
fun HorizontalPagerView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        var beyondPageCount by remember { mutableIntStateOf(1) }
        val state = rememberPagerState(pageCount = { 50 })
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state,
            beyondViewportPageCount = beyondPageCount
        ) { page ->
            PagerItem(
                page = page,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        FlowRow(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            repeat(3) { count ->
                Button(onClick = {
                    beyondPageCount = count + 1 * count + 1
                    Log.d("TAG", "beyondViewportPageCount set to ${count + 1 * count + 1}")
                }) {
                    Text("Beyond Page Count: ${count + 1 * count + 1}")
                }
            }
        }
    }
}

@Preview
@Composable
fun previewHorizontalPagerViewV4() {
    HorizontalPagerView()
}
