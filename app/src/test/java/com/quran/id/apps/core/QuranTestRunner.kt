package com.quran.id.apps.core

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.quran.id.apps.base.TestApplication

class QuranTestRunner : AndroidJUnitRunner() {

  override fun newApplication(
    cl: ClassLoader?,
    className: String?,
    context: Context?
  ): Application {
    return super.newApplication(cl, TestApplication::class.qualifiedName, context)
  }
}
