package com.quran.id.apps.di.module.fragment

import dagger.Module
import dagger.Provides

@Module
class QuranPageModule(private vararg val pages: Int) {

  @Provides
  fun providePages(): IntArray {
    return pages
  }
}
