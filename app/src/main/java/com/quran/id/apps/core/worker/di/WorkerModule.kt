package com.quran.id.apps.core.worker.di

import com.quran.id.apps.core.worker.WorkerKey
import com.quran.id.apps.core.worker.WorkerTaskFactory
import com.quran.id.apps.worker.AudioUpdateWorker
import com.quran.id.apps.worker.MissingPageDownloadWorker
import com.quran.id.apps.worker.PartialPageCheckingWorker
import com.quran.id.apps.worker.PartialPageCheckingWorker.Factory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ AudioUpdateModule::class ])
abstract class WorkerModule {

  @Binds
  @IntoMap
  @WorkerKey(PartialPageCheckingWorker::class)
  abstract fun bindPartialPageCheckingWorkerFactory(
    workerFactory: Factory
  ): WorkerTaskFactory

  @Binds
  @IntoMap
  @WorkerKey(MissingPageDownloadWorker::class)
  abstract fun bindMissingPageDownloadWorkerFactory(
    workerFactory: MissingPageDownloadWorker.Factory
  ): WorkerTaskFactory

  @Binds
  @IntoMap
  @WorkerKey(AudioUpdateWorker::class)
  abstract fun bindAudioUpdateWorkerFactory(
    workerFactory: AudioUpdateWorker.Factory
  ): WorkerTaskFactory
}
