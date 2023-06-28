package com.quran.id.apps.base

import com.quran.id.apps.QuranApplication
import com.quran.id.apps.di.DaggerTestApplicationComponent
import com.quran.id.apps.di.component.application.ApplicationComponent
import com.quran.id.apps.di.module.application.ApplicationModule

class TestApplication : QuranApplication() {

  override fun initializeInjector(): ApplicationComponent {
    return DaggerTestApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()
  }

  override fun setupTimber() {
  }

  override fun initializeWorkManager() {
  }
}
