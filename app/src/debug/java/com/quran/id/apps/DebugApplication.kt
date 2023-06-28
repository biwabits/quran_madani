package com.quran.id.apps

import timber.log.Timber
import timber.log.Timber.DebugTree

class DebugApplication : QuranApplication() {
  override fun setupTimber() {
    Timber.plant(DebugTree())
  }
}
