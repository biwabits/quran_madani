package com.quran.id.apps.ui.helpers

import com.quran.data.model.selection.SelectionIndicator
import com.quran.id.apps.common.LocalTranslation
import com.quran.id.apps.common.QuranAyahInfo

interface AyahTracker {
  fun getToolBarPosition(sura: Int, ayah: Int): SelectionIndicator
  fun getQuranAyahInfo(sura: Int, ayah: Int): QuranAyahInfo?
  fun getLocalTranslations(): Array<LocalTranslation>?
}
