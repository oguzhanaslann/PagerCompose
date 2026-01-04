package com.oguzhanaslann.pagercompose.v1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.oguzhanaslann.pagercompose.PagerItem
import com.oguzhanaslann.pagercompose.R
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

        ControlButtons(state)
    }
}

@Composable
private fun BoxScope.ControlButtons(state: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
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
                painter = painterResource(R.drawable.baseline_arrow_back_24),
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
                painter = painterResource(R.drawable.outline_arrow_forward_24),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun previewHorizontalPagerViewV1() {
    HorizontalPagerView()
}
