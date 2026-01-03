package com.oguzhanaslann.pagercompose.v5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.oguzhanaslann.pagercompose.PagerItem

@Composable
fun HorizontalPagerView(
    viewModel: HorizontalPagerViewModel = viewModel()
) {
    val items = viewModel.items.collectAsLazyPagingItems()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val state = rememberPagerState(pageCount = { items.itemCount })
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state,
        ) { page ->
            items[page]?.let { item ->
                PagerItem(
                    page = item,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
fun previewHorizontalPagerViewV5() {
    HorizontalPagerView()
}
