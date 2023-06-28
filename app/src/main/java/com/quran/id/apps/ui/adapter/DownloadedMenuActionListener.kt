package com.quran.id.apps.ui.adapter

import com.quran.id.apps.dao.translation.TranslationItem

interface DownloadedMenuActionListener {
  fun startMenuAction(item: TranslationItem, downloadedItemActionListener: DownloadedItemActionListener?)
  fun finishMenuAction()
}
