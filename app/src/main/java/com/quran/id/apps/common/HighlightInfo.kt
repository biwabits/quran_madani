package com.quran.id.apps.common

import com.quran.id.apps.ui.helpers.HighlightType

class HighlightInfo(
  val sura: Int,
  val ayah: Int,
  val word: Int,
  val highlightType: HighlightType,
  val scrollToAyah: Boolean
)
