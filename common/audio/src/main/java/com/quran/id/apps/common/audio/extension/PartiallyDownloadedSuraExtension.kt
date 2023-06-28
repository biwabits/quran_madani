package com.quran.id.apps.common.audio.extension

import com.quran.id.apps.common.audio.model.PartiallyDownloadedSura

fun PartiallyDownloadedSura.didDownloadAyat(currentSura: Int, start: Int, end: Int): Boolean {
  val ayat = IntRange(start, end)
  return sura == currentSura && ayat.all { it in downloadedAyat }
}
