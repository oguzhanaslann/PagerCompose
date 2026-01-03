package com.oguzhanaslann.pagercompose.v1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.oguzhanaslann.pagercompose.PagerItem
import kotlinx.coroutines.launch
import kotlin.math.max
import kotlin.math.min

@Composable
fun VerticalPagerView() {
    Box {
        val state = rememberPagerState { 3 }
        VerticalPager(
            modifier = Modifier.fillMaxSize(),
            state = state
        ) {
            PagerItem(
                modifier = Modifier.fillMaxSize(),
                page = it
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterStart),
        ) {
            val coroutineScope = rememberCoroutineScope()
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        state.animateScrollToPage(max(state.currentPage - 1, 0))
                    }
                },
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = {
                    coroutineScope.launch {
                        state.animateScrollToPage(min(state.currentPage + 1, 3))
                    }
                },
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun previewVerticalPagerView() {
    VerticalPagerView()
}
