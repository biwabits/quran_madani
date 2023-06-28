package com.quran.id.apps.di.component.activity

import com.quran.data.di.QuranReadingScope
import com.quran.data.di.ActivityScope
import com.quran.id.apps.di.component.fragment.QuranPageComponent
import com.quran.id.apps.di.module.activity.PagerActivityModule
import com.quran.id.apps.ui.PagerActivity
import com.quran.id.apps.ui.fragment.AyahPlaybackFragment
import com.quran.id.apps.ui.fragment.AyahTranslationFragment
import com.quran.id.apps.ui.fragment.TagBookmarkFragment
import com.quran.page.common.toolbar.AyahToolBar
import com.quran.mobile.di.QuranReadingActivityComponent
import com.quran.mobile.feature.qarilist.QariListWrapper
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent

@ActivityScope
@MergeSubcomponent(QuranReadingScope::class, modules = [PagerActivityModule::class])
interface PagerActivityComponent : QuranReadingActivityComponent {
  // subcomponents
  fun quranPageComponentBuilder(): QuranPageComponent.Builder

  fun inject(pagerActivity: PagerActivity)
  fun inject(ayahToolBar: AyahToolBar)

  fun inject(tagBookmarkFragment: TagBookmarkFragment)
  fun inject(ayahPlaybackFragment: AyahPlaybackFragment)
  fun inject(ayahTranslationFragment: AyahTranslationFragment)

  fun inject(qariListWrapper: QariListWrapper)

  @Subcomponent.Builder
  interface Builder {
    fun withPagerActivityModule(pagerModule: PagerActivityModule): Builder
    fun build(): PagerActivityComponent
  }
}
