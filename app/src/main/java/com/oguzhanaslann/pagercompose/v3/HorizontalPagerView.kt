package com.oguzhanaslann.pagercompose.v3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
        val state =   rememberPagerState { 50 }
        var portCount by remember { mutableIntStateOf(1) }
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state,
            beyondViewportPageCount = portCount
        ) {
            PagerItem(
                modifier = Modifier.fillMaxSize(),
                page = it
            )
        }


        FlowRow(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            repeat(3) { index ->
                Button(
                    onClick = {
                        portCount = (index + 1) * (index + 1)
                    },
                ) {
                    Text("ViewPort : ${(index+1)*(index+1)}")
                }
            }
        }
    }
}

@Preview
@Composable
fun previewHorizontalPagerViewBeyondViewportPageCount() {
    HorizontalPagerView()
}
