package com.quran.id.apps.dao.translation

class TranslationItemDisplaySort : Comparator<TranslationItem> {
  override fun compare(first: TranslationItem, second: TranslationItem): Int {
    return first.displayOrder.compareTo(second.displayOrder)
  }
}
