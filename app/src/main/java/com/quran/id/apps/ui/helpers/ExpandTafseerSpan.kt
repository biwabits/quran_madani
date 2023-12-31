package com.quran.id.apps.ui.helpers

import android.text.style.ClickableSpan
import android.view.View

class ExpandTafseerSpan(private val listener: View.OnClickListener) : ClickableSpan() {
  override fun onClick(widget: View) {
    listener.onClick(widget)
  }
}
