package com.quran.id.apps.database

import android.content.Context
import com.quran.data.dao.TranslationsDao
import com.quran.data.model.QuranText
import com.quran.data.model.VerseRange
import com.quran.id.apps.data.QuranDataProvider
import com.quran.id.apps.database.DatabaseHandler.TextType.Companion.TRANSLATION
import com.quran.id.apps.util.QuranFileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TranslationsDaoImpl @Inject constructor(
  private val appContext: Context,
  private val quranFileUtils: QuranFileUtils,
) : TranslationsDao {

  override suspend fun allAyahs(): List<QuranText> {
    return withContext(Dispatchers.IO) {
      val databaseHandler = DatabaseHandler.getDatabaseHandler(
        appContext, QuranDataProvider.QURAN_ARABIC_DATABASE, quranFileUtils)
      databaseHandler.getVerses(VerseRange(1, 1, 114, 6, -1), TRANSLATION)
    }
  }
}
