package com.oguzhanaslann.pagercompose.v3

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
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
        val fling = PagerDefaults.flingBehavior(
            state = state,
            pagerSnapDistance = PagerSnapDistance.atMost(3)
        )

        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state,
            pageSize = threePagesPerViewport,
            snapPosition = SnapPosition.Center,
            flingBehavior = fling
        ) {page ->
            PagerItem(
                page = page,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .then(
                        if (state.currentPage == page) {
                            Modifier.border(4.dp, Color.Black)
                        } else {
                            Modifier
                        }
                    )
            )
        }
    }
}

private val threePagesPerViewport = object : PageSize {
    override fun Density.calculateMainAxisPageSize(
        availableSpace: Int,
        pageSpacing: Int
    ): Int {
        return (availableSpace - 2 * pageSpacing) / 3
    }
}





@Preview
@Composable
fun previewHorizontalPagerViewBeyondViewportPageCount() {
    HorizontalPagerView()
}
