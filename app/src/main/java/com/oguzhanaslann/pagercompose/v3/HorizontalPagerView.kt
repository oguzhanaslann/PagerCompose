package com.oguzhanaslann.pagercompose.v3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oguzhanaslann.pagercompose.PagerItem

@Composable
fun HorizontalPagerView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val state = rememberPagerState { 50 }
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state,
        ) {
            PagerItem(
                page = it,
                modifier = Modifier
                    .fillMaxWidth()
//                    .width(200.dp)
                    .height(200.dp)
            )
        }
    }
}


@Preview
@Composable
fun previewHorizontalPagerViewBeyondViewportPageCount() {
    HorizontalPagerView()
}
