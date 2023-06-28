package com.quran.id.apps.di.component.activity

import com.quran.id.apps.di.module.activity.QuranActivityModule
import com.quran.id.apps.ui.QuranActivity
import dagger.Subcomponent

@Subcomponent(modules = [QuranActivityModule::class])
interface QuranActivityComponent {
  fun inject(quranActivity: QuranActivity)

  @Subcomponent.Builder
  interface Builder {
    fun build(): QuranActivityComponent
  }
}
