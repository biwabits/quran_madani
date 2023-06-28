package com.quran.id.apps.presenter.quran.ayahtracker

import com.quran.data.core.QuranInfo
import com.quran.data.model.SuraAyah
import com.quran.data.model.highlight.HighlightType
import com.quran.data.model.selection.SelectionIndicator
import com.quran.id.apps.common.LocalTranslation
import com.quran.id.apps.common.QuranAyahInfo
import com.quran.id.apps.ui.translation.TranslationView

class AyahTranslationTrackerItem(
  page: Int,
  private val quranInfo: QuranInfo,
  private val ayahView: TranslationView
) : AyahTrackerItem(page) {

  override fun onHighlightAyah(
    page: Int, sura: Int, ayah: Int, word: Int, type: HighlightType, scrollToAyah: Boolean
  ): Boolean {
    if (this.page == page) {
      ayahView.highlightAyah(SuraAyah(sura, ayah), quranInfo.getAyahId(sura, ayah), type)
      return true
    }
    ayahView.unhighlightAyah(type)
    return false
  }

  override fun onUnHighlightAyah(page: Int, sura: Int, ayah: Int, type: HighlightType) {
    if (this.page == page) {
      ayahView.unhighlightAyah(type)
    }
  }

  override fun onUnHighlightAyahType(type: HighlightType) {
    ayahView.unhighlightAyat(type)
  }

  override fun getToolBarPosition(page: Int, sura: Int, ayah: Int): SelectionIndicator {
    return ayahView.getToolbarPosition(sura, ayah)
  }

  override fun getQuranAyahInfo(sura: Int, ayah: Int): QuranAyahInfo? {
    val quranAyahInfo = ayahView.getQuranAyahInfo(sura, ayah)
    return quranAyahInfo ?: super.getQuranAyahInfo(sura, ayah)
  }

  override fun getLocalTranslations(): Array<LocalTranslation>? {
    val translations = ayahView.localTranslations
    return translations ?: super.getLocalTranslations()
  }
}
