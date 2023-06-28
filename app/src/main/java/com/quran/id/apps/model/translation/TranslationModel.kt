package com.quran.id.apps.model.translation

import android.content.Context
import com.quran.data.model.QuranText
import com.quran.data.model.VerseRange
import com.quran.data.pageinfo.mapper.AyahMapper
import com.quran.id.apps.data.QuranDataProvider
import com.quran.id.apps.database.DatabaseHandler
import com.quran.id.apps.database.DatabaseHandler.TextType
import com.quran.data.di.ActivityScope
import com.quran.id.apps.util.QuranFileUtils
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@ActivityScope
class TranslationModel @Inject internal constructor(
  private val appContext: Context,
  private val quranFileUtils: QuranFileUtils,
  private val ayahMapper: AyahMapper
) {

  fun getArabicFromDatabase(verses: VerseRange): Single<List<QuranText>> {
    return getVersesFromDatabase(
        verses,
        QuranDataProvider.QURAN_ARABIC_DATABASE,
        TextType.ARABIC,
        shouldMap = false
    )
  }

  fun getTranslationFromDatabase(verses: VerseRange, db: String): Single<List<QuranText>> {
    return getVersesFromDatabase(verses, db, TextType.TRANSLATION, shouldMap = true)
  }

  private fun getVersesFromDatabase(
    verses: VerseRange,
    database: String,
    @TextType type: Int,
    shouldMap: Boolean = false
  ): Single<List<QuranText>> {
    return Single.fromCallable {
      val databaseHandler = DatabaseHandler.getDatabaseHandler(appContext, database, quranFileUtils)

      if (shouldMap) {
        val mappedRange = ayahMapper.mapRange(verses)
        val data = databaseHandler.getVerses(mappedRange, type)
        ayahMapper.mapKufiData(verses, data)
      } else {
        databaseHandler.getVerses(verses, type)
      }
    }
  }
}
