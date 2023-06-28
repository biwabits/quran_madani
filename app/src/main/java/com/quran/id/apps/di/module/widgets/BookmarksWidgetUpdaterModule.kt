package com.quran.id.apps.di.module.widgets

import com.quran.id.apps.widget.BookmarksWidgetUpdater
import com.quran.id.apps.widget.BookmarksWidgetUpdaterImpl
import dagger.Binds
import dagger.Module

@Module
interface BookmarksWidgetUpdaterModule {

  @Binds
  fun bindBookmarksWidgetUpdater(impl: BookmarksWidgetUpdaterImpl): BookmarksWidgetUpdater
}
