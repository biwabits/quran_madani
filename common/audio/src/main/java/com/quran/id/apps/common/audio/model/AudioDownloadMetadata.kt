package com.quran.id.apps.common.audio.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AudioDownloadMetadata(val qariId: Int) : Parcelable
