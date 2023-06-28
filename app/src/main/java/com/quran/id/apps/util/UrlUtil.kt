package com.quran.id.apps.util

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UrlUtil @Inject constructor() {

  fun fallbackUrl(url: String): String {
    return url.replace(".quranicaudio.com", ".quranicaudio.org")
  }
}
