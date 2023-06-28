package com.quran.id.apps.feature.audio.util

import java.io.File

interface HashCalculator {
  fun calculateHash(file: File): String
}
