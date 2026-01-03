package com.oguzhanaslann.pagercompose.v5

import androidx.paging.PagingSource
import androidx.paging.PagingState

class IntPagingSource : PagingSource<Int, Int>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Int> {
        val page = params.key ?: 1
        val pageSize = params.loadSize
        val items = (page..page + pageSize).toList()

        return LoadResult.Page(
            data = items,
            prevKey = if (page == 1) null else page - 1,
            nextKey = page + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Int>): Int? {
        return state.anchorPosition
    }
}
