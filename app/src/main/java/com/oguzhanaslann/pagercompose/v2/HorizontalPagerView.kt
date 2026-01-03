package com.oguzhanaslann.pagercompose.v2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oguzhanaslann.pagercompose.PagerIndicator
import com.oguzhanaslann.pagercompose.PagerItem
import kotlinx.coroutines.launch
import kotlin.math.max
import kotlin.math.min

@Composable
fun HorizontalPagerView() {
    Box {
        val state =   rememberPagerState { 3 }
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state
        ) {
            PagerItem(
                modifier = Modifier.fillMaxSize(),
                page = it
            )
        }

        PagerIndicator(
            pageCount = state.pageCount,
            currentPageIndex = state.currentPage,
            dotSize = 10.dp,
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
fun previewHorizontalPagerView() {
    HorizontalPagerView()
}
