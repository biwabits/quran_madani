package com.quran.id.apps.dao.bookmark

import com.quran.data.model.bookmark.Tag
import com.quran.id.apps.ui.helpers.QuranRow

data class BookmarkResult(val rows: List<QuranRow>, val tagMap: Map<Long, Tag>)
