package com.quran.id.apps.di.component.fragment

import com.quran.data.di.QuranPageScope
import com.quran.data.di.QuranReadingPageScope
import com.quran.data.page.provider.di.QuranPageExtrasComponent
import com.quran.id.apps.di.module.fragment.QuranPageModule
import com.quran.id.apps.ui.fragment.QuranPageFragment
import com.quran.id.apps.ui.fragment.TabletFragment
import com.quran.id.apps.ui.fragment.TranslationFragment
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent

@QuranPageScope
@MergeSubcomponent(QuranReadingPageScope::class, modules = [QuranPageModule::class])
interface QuranPageComponent: QuranPageExtrasComponent {
  fun inject(quranPageFragment: QuranPageFragment)
  fun inject(tabletFragment: TabletFragment)
  fun inject(translationFragment: TranslationFragment)

  @Subcomponent.Builder
  interface Builder {
    fun withQuranPageModule(quranPageModule: QuranPageModule): Builder
    fun build(): QuranPageComponent
  }
}
