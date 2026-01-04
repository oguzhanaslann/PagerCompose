package com.oguzhanaslann.pagercompose.v6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class HorizontalPagerViewModel : ViewModel() {
    val items: Flow<PagingData<Int>> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { IntPagingSource() }
    ).flow.cachedIn(viewModelScope)
}
