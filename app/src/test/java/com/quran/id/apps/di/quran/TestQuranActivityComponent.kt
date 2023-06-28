package com.quran.id.apps.di.quran

import com.quran.data.di.ActivityScope
import com.quran.id.apps.di.component.activity.QuranActivityComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [TestQuranActivityModule::class])
interface TestQuranActivityComponent : QuranActivityComponent {

  @Subcomponent.Builder
  interface Builder : QuranActivityComponent.Builder {
    override fun build(): TestQuranActivityComponent
  }
}
