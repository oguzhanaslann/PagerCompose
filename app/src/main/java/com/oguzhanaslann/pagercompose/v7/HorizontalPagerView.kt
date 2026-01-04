package com.oguzhanaslann.pagercompose.v7

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.oguzhanaslann.pagercompose.PagerItem
import kotlin.math.absoluteValue
import kotlin.math.max

@Composable
fun HorizontalPagerView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val state = rememberPagerState { 10 }
        val density = LocalDensity.current
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state,
            pageSpacing = 16.dp,
            snapPosition = SnapPosition.Center,
            pageSize = threePagesPerViewport,
        ) {page ->

            PagerItem(
                page = page,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .graphicsLayer {
                        // Calculate the signed offset for the current page from the
                        // scroll position.
                        animateRadially(state, page, density)
                    }
            )
        }
    }
}

private fun GraphicsLayerScope.animateRadially(
    state: PagerState,
    page: Int,
    density: Density
) {
    val pageOffset = ((state.currentPage - page) + state.currentPageOffsetFraction)

    // We animate the alpha, between 50% and 100%
    alpha = lerp(
        start = 0.3f,
        stop = 1f,
        fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
    )

    // We animate the scale, between 80% and 100%
    val scale = lerp(
        start = 0.8f,
        stop = 1f,
        fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
    )
    scaleX = scale
    scaleY = scale

    // Add a 3D rotation effect (radial animation)
    rotationY = pageOffset * -30f
    cameraDistance = 12 * density.density
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
fun previewHorizontalPagerViewBeyondV6() {
    HorizontalPagerView()
}
