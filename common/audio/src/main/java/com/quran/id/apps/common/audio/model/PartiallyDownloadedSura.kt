package com.quran.id.apps.common.audio.model

data class PartiallyDownloadedSura(val sura: Int, val expectedAyahCount: Int, val downloadedAyat: List<Int>)
