package com.quran.id.apps.database

import com.quran.id.apps.feature.audio.VersionableDatabaseChecker
import javax.inject.Inject

class AudioDatabaseVersionChecker @Inject constructor() : VersionableDatabaseChecker {
  override fun getVersionForDatabase(path: String): Int {
    return SuraTimingDatabaseHandler.getDatabaseHandler(path).getVersion()
  }
}
