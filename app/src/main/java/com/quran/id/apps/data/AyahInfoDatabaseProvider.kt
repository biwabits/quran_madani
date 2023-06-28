package com.quran.id.apps.data

import android.content.Context
import com.quran.data.di.ActivityScope
import com.quran.id.apps.util.QuranFileUtils
import javax.inject.Inject

@ActivityScope
class AyahInfoDatabaseProvider @Inject constructor(
  private val context: Context,
  private val widthParameter: String,
  private val quranFileUtils: QuranFileUtils
) {
  private var databaseHandler: AyahInfoDatabaseHandler? = null

  fun getAyahInfoHandler(): AyahInfoDatabaseHandler? {
    if (databaseHandler == null) {
      val filename = quranFileUtils.getAyaPositionFileName(widthParameter)
      databaseHandler = AyahInfoDatabaseHandler.getAyahInfoDatabaseHandler(
        context, filename,
        quranFileUtils
      )
    }
    return databaseHandler
  }

  fun getPageWidth(): Int = widthParameter.substring(1).toInt()
}
