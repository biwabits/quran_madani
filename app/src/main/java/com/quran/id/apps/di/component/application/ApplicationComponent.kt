package com.quran.id.apps.di.component.application

import com.quran.analytics.provider.AnalyticsModule
import com.quran.common.networking.NetworkModule
import com.quran.data.di.AppScope
import com.quran.data.page.provider.QuranDataModule
import com.quran.id.apps.QuranApplication
import com.quran.id.apps.QuranDataActivity
import com.quran.id.apps.QuranForwarderActivity
import com.quran.id.apps.QuranImportActivity
import com.quran.id.apps.SearchActivity
import com.quran.id.apps.core.worker.di.WorkerModule
import com.quran.id.apps.data.QuranDataProvider
import com.quran.id.apps.di.component.activity.PagerActivityComponent
import com.quran.id.apps.di.component.activity.QuranActivityComponent
import com.quran.id.apps.di.module.application.ApplicationModule
import com.quran.id.apps.di.module.application.DatabaseModule
import com.quran.id.apps.di.module.application.PageAggregationModule
import com.quran.id.apps.di.module.widgets.BookmarksWidgetUpdaterModule
import com.quran.id.apps.pageselect.PageSelectActivity
import com.quran.id.apps.service.AudioService
import com.quran.id.apps.service.QuranDownloadService
import com.quran.id.apps.ui.TranslationManagerActivity
import com.quran.id.apps.ui.fragment.AddTagDialog
import com.quran.id.apps.ui.fragment.BookmarksFragment
import com.quran.id.apps.ui.fragment.JumpFragment
import com.quran.id.apps.ui.fragment.JuzListFragment
import com.quran.id.apps.ui.fragment.QuranAdvancedSettingsFragment
import com.quran.id.apps.ui.fragment.QuranSettingsFragment
import com.quran.id.apps.ui.fragment.SuraListFragment
import com.quran.id.apps.ui.fragment.TagBookmarkDialog
import com.quran.id.apps.widget.BookmarksWidget
import com.quran.id.apps.widget.BookmarksWidgetListProvider
import com.quran.id.apps.widget.ShowJumpFragmentActivity
import com.quran.mobile.di.QuranApplicationComponent
import com.squareup.anvil.annotations.MergeComponent
import javax.inject.Singleton

@Singleton
@MergeComponent(
  AppScope::class,
  modules = [
    AnalyticsModule::class,
    ApplicationModule::class,
    DatabaseModule::class,
    NetworkModule::class,
    PageAggregationModule::class,
    QuranDataModule::class,
    WorkerModule::class,
    BookmarksWidgetUpdaterModule::class
  ]
)
interface ApplicationComponent: QuranApplicationComponent {
  // subcomponents
  fun pagerActivityComponentBuilder(): PagerActivityComponent.Builder
  fun quranActivityComponentBuilder(): QuranActivityComponent.Builder

  // application
  fun inject(quranApplication: QuranApplication)

  // content provider
  fun inject(quranDataProvider: QuranDataProvider)

  // services
  fun inject(audioService: AudioService)
  fun inject(quranDownloadService: QuranDownloadService)

  // activities
  fun inject(quranDataActivity: QuranDataActivity)
  fun inject(quranImportActivity: QuranImportActivity)
  fun inject(quranForwarderActivity: QuranForwarderActivity)
  fun inject(searchActivity: SearchActivity)
  fun inject(pageSelectActivity: PageSelectActivity)
  fun inject(showJumpFragmentActivity: ShowJumpFragmentActivity)

  // fragments
  fun inject(bookmarksFragment: BookmarksFragment)
  fun inject(fragment: QuranSettingsFragment)
  fun inject(translationManagerActivity: TranslationManagerActivity)
  fun inject(quranAdvancedSettingsFragment: QuranAdvancedSettingsFragment)
  fun inject(suraListFragment: SuraListFragment)
  fun inject(juzListFragment: JuzListFragment)
  fun inject(jumpFragment: JumpFragment)

  // dialogs
  fun inject(tagBookmarkDialog: TagBookmarkDialog)
  fun inject(addTagDialog: AddTagDialog)

  // widgets
  fun inject(bookmarksWidgetListProvider: BookmarksWidgetListProvider)
  fun inject(bookmarksWidget: BookmarksWidget)
}
