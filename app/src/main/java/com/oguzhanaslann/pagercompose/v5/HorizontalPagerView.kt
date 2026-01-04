package com.oguzhanaslann.pagercompose.v5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
        var pages by remember { mutableStateOf<List<String>>(emptyList()) }
        val state = rememberPagerState(pageCount = pages::size)
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = state,
        ) { page ->
            PagerItem(
                page = page,
                modifier = Modifier
                    .fillMaxSize()
            )
        }


        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = {
                pages = pages
                    .toMutableList()
                    .apply {
                        add("New Page: ${pages.size + 1}")
                    }
            }
        ) {
            Text("Add Page")
        }
    }
}

@Preview
@Composable
fun previewHorizontalPagerViewV5() {
    HorizontalPagerView()
}
