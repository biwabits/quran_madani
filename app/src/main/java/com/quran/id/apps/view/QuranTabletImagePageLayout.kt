package com.quran.id.apps.view

import android.content.Context

class QuranTabletImagePageLayout(context: Context) : QuranImagePageLayout(context) {

  override fun shouldWrapWithScrollView(): Boolean = false
}
