package com.quran.mobile.feature.qarilist.model

import androidx.annotation.StringRes
import com.quran.id.apps.common.audio.model.QariItem

data class QariUiModel(
  val qariItem: QariItem,
  @StringRes val sectionHeader: Int
)
