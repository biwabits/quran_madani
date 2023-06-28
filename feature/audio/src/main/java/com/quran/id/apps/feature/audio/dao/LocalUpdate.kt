package com.quran.id.apps.feature.audio.dao

import com.quran.id.apps.common.audio.model.QariItem

data class LocalUpdate(val qari: QariItem,
                       val files: List<String> = emptyList(),
                       val needsDatabaseUpgrade: Boolean = false)
