package com.quran.id.apps.view

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import com.quran.id.apps.ui.helpers.AyahSelectedListener
import com.quran.id.apps.ui.util.PageController
import com.quran.id.apps.util.QuranSettings

/**
 * Layout class for a single Arabic page of the Quran, with margins/background.
 * <p>
 * Note that the image of the Quran page to be displayed is set by users of this class by calling
 * {@link #getImageView()} and calling the appropriate methods on that view.
 */
open class QuranImagePageLayout(context: Context) : QuranPageLayout(context) {

  private lateinit var imageView: HighlightingImageView

  init {
    this.initialize()
  }

  override fun generateContentView(context: Context, isLandscape: Boolean): View {
    imageView = HighlightingImageView(context).apply {
      adjustViewBounds = true
      setIsScrollable(isLandscape && shouldWrapWithScrollView(), isLandscape)
    }
    return imageView
  }

  override fun updateView(quranSettings: QuranSettings) {
    super.updateView(quranSettings)
    imageView.setNightMode(quranSettings.isNightMode, quranSettings.nightModeTextBrightness, quranSettings.nightModeBackgroundBrightness)
  }

  override fun setPageController(controller: PageController?, pageNumber: Int) {
    super.setPageController(controller, pageNumber)
    val gestureDetector = GestureDetector(context, PageGestureDetector())
    val gestureListener = OnTouchListener { _, event ->
      gestureDetector.onTouchEvent(event)
    }
    imageView.setOnTouchListener(gestureListener)
    imageView.isClickable = true
    imageView.isLongClickable = true
  }

  fun getImageView(): HighlightingImageView = imageView

  inner class PageGestureDetector : GestureDetector.SimpleOnGestureListener() {
    override fun onDown(e: MotionEvent): Boolean = true

    override fun onSingleTapUp(event: MotionEvent): Boolean {
      return pageController.handleTouchEvent(
        event,
        AyahSelectedListener.EventType.SINGLE_TAP,
        pageNumber
      )
    }

    override fun onDoubleTap(event: MotionEvent): Boolean {
      return pageController.handleTouchEvent(
        event,
        AyahSelectedListener.EventType.DOUBLE_TAP,
        pageNumber
      )
    }

    override fun onLongPress(event: MotionEvent) {
      pageController.handleTouchEvent(
        event,
        AyahSelectedListener.EventType.LONG_PRESS,
        pageNumber
      )
    }
  }
}
