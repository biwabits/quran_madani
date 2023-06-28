package com.quran.id.apps.feature.audio

interface VersionableDatabaseChecker {
  fun getVersionForDatabase(path: String): Int
}
