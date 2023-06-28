package com.quran.id.apps.di.module.activity

import com.quran.id.apps.presenter.data.QuranIndexEventLogger
import com.quran.id.apps.presenter.data.QuranIndexEventLoggerImpl
import dagger.Binds
import dagger.Module

@Module
interface QuranActivityModule {
  @Binds
  fun bindQuranIndexEventLogger(impl: QuranIndexEventLoggerImpl): QuranIndexEventLogger
}
