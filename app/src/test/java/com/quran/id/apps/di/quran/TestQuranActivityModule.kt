package com.quran.id.apps.di.quran

import com.quran.id.apps.presenter.data.QuranIndexEventLogger
import dagger.Module
import dagger.Provides

@Module
class TestQuranActivityModule {

  @Provides
  fun bindQuranIndexEventLogger(): QuranIndexEventLogger {
    return QuranIndexEventLogger { }
  }
}
