package com.quran.id.apps.dao.audio

import android.os.Parcelable
import com.quran.id.apps.common.audio.model.QariItem
import com.quran.data.model.SuraAyah
import kotlinx.parcelize.Parcelize

@Parcelize
data class AudioRequest(val start: SuraAyah,
                        val end: SuraAyah,
                        val qari: QariItem,
                        val repeatInfo: Int = 0,
                        val rangeRepeatInfo: Int = 0,
                        val enforceBounds: Boolean,
                        val shouldStream: Boolean,
                        val audioPathInfo: AudioPathInfo) : Parcelable {
  fun isGapless() = qari.isGapless
  fun needsIsti3athaAudio() =
      !isGapless() || audioPathInfo.gaplessDatabase?.contains("minshawi_murattal") ?: false
}
