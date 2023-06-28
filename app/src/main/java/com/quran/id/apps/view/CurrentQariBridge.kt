package com.quran.id.apps.view

import com.quran.data.model.audio.Qari
import com.quran.id.apps.common.audio.repository.CurrentQariManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrentQariBridge @Inject constructor(private val currentQariManager: CurrentQariManager) {
  private val scope: CoroutineScope = CoroutineScope(SupervisorJob())

  fun listenToQaris(lambda: ((Qari) -> Unit)) {
    scope.launch {
      withContext(Dispatchers.Main) {
        currentQariManager
          .flow()
          .collect { lambda(it) }
      }
    }
  }

  fun unsubscribeAll() {
    scope.cancel()
  }
}
