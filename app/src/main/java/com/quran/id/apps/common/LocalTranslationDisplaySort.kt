package com.quran.id.apps.common

class LocalTranslationDisplaySort : Comparator<LocalTranslation> {
  override fun compare(first: LocalTranslation, second: LocalTranslation): Int {
    return first.displayOrder.compareTo(second.displayOrder)
  }
}
