package com.oguzhanaslann.pagercompose

class ImageProvider {
    fun getImageUrl(width: Int, height: Int): String {
        return "https://picsum.photos/$width/$height"
    }
}