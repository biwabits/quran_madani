package com.quran.id.apps.ui.helpers

import android.text.style.ClickableSpan
import android.view.View

class ExpandFootnoteSpan(
  private val number: Int,
  private val expander: ((View, Int) -> Unit)
) : ClickableSpan() {

  override fun onClick(widget: View) {
    expander(widget, number)
  }
}
