package com.quran.id.apps.presenter

interface Presenter<T : Any> {
  fun bind(what: T)
  fun unbind(what: T)
}
