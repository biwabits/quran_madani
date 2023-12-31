package com.quran.id.apps.presenter.quran

import com.quran.data.core.QuranInfo
import com.quran.data.di.QuranPageScope
import com.quran.id.apps.R
import com.quran.id.apps.common.Response
import com.quran.id.apps.model.quran.CoordinatesModel
import com.quran.id.apps.presenter.Presenter
import com.quran.id.apps.ui.helpers.QuranPageLoader
import com.quran.id.apps.util.QuranSettings
import com.quran.page.common.data.AyahCoordinates
import com.quran.page.common.data.PageCoordinates
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@QuranPageScope
class QuranPagePresenter @Inject constructor(
  private val coordinatesModel: CoordinatesModel,
  private val quranSettings: QuranSettings,
  private val quranPageLoader: QuranPageLoader,
  private val quranInfo: QuranInfo,
  private val pages: IntArray,
) : Presenter<QuranPageScreen> {

  private val compositeDisposable: CompositeDisposable = CompositeDisposable()

  private var screen: QuranPageScreen? = null
  private var encounteredError = false
  private var didDownloadImages = false

  override fun bind(screen: QuranPageScreen) {
    this.screen = screen
    if (!didDownloadImages) {
      downloadImages()
    }
    getPageCoordinates(pages)
  }

  override fun unbind(screen: QuranPageScreen) {
    this.screen = null
    compositeDisposable.clear()
  }

  private fun getPageCoordinates(pages: IntArray) {
    compositeDisposable.add(
      coordinatesModel.getPageCoordinates(quranSettings.shouldOverlayPageInfo(), *pages.toTypedArray())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(object : DisposableObserver<PageCoordinates>() {
          override fun onNext(pageCoordinates: PageCoordinates) {
            screen?.setPageCoordinates(pageCoordinates)
          }

          override fun onError(e: Throwable) {
            encounteredError = true
            screen?.setAyahCoordinatesError()
          }

          override fun onComplete() {
            getAyahCoordinates(pages)
          }
        })
    )
  }

  private fun getAyahCoordinates(pages: IntArray) {
    compositeDisposable.add(
      Completable.timer(500, TimeUnit.MILLISECONDS)
        .andThen(Observable.fromArray(*pages.toTypedArray()))
        .flatMap { coordinatesModel.getAyahCoordinates(it) }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(object : DisposableObserver<AyahCoordinates>() {
          override fun onNext(coordinates: AyahCoordinates) {
            screen?.setAyahCoordinatesData(coordinates)
          }

          override fun onError(e: Throwable) {}

          override fun onComplete() {}
        })
    )
  }

  fun downloadImages() {
    screen?.hidePageDownloadError()
    // drop empty pages - this happens in Shemerly, for example, where there are an odd number of
    // pages. in dual page mode, we have an empty page at the end, so we don't want to try to load
    // the empty page.
    val actualPages = pages.filter { it <= quranInfo.numberOfPages }
    compositeDisposable.add(
      quranPageLoader.loadPages(actualPages.toTypedArray())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(object : DisposableObserver<Response>() {
          override fun onNext(response: Response) {
            screen?.let { pageScreen ->
              val bitmap = response.bitmap
              if (bitmap != null) {
                didDownloadImages = true
                pageScreen.setPageBitmap(response.pageNumber, bitmap)
              } else {
                didDownloadImages = false
                val errorRes: Int = when (response.errorCode) {
                    Response.ERROR_SD_CARD_NOT_FOUND -> R.string.sdcard_error
                    Response.ERROR_NO_INTERNET, Response.ERROR_DOWNLOADING_ERROR -> R.string.download_error_network
                    else -> R.string.download_error_general
                  }
                pageScreen.setPageDownloadError(errorRes)
              }
            }
          }

          override fun onError(e: Throwable) {}

          override fun onComplete() {}
        })
    )
  }

  fun refresh() {
    if (encounteredError) {
      encounteredError = false
      getPageCoordinates(pages)
    }
  }
}
