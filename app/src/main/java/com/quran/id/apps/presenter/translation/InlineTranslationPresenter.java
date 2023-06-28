package com.quran.id.apps.presenter.translation;

import com.quran.data.core.QuranInfo;
import com.quran.id.apps.common.LocalTranslation;
import com.quran.id.apps.common.QuranAyahInfo;
import com.quran.data.model.VerseRange;
import com.quran.id.apps.database.TranslationsDBAdapter;
import com.quran.id.apps.model.translation.TranslationModel;
import com.quran.id.apps.util.QuranSettings;
import com.quran.id.apps.util.TranslationUtil;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;

public class InlineTranslationPresenter extends
    BaseTranslationPresenter<InlineTranslationPresenter.TranslationScreen> {
  private final QuranSettings quranSettings;

  @Inject
  InlineTranslationPresenter(TranslationModel translationModel,
                             TranslationsDBAdapter dbAdapter,
                             TranslationUtil translationUtil,
                             QuranSettings quranSettings,
                             QuranInfo quranInfo) {
    super(translationModel, dbAdapter, translationUtil, quranInfo);
    this.quranSettings = quranSettings;
  }

  public void refresh(VerseRange verseRange) {
    if (getDisposable() != null) {
      getDisposable().dispose();
    }

    setDisposable(getVerses(false, getTranslations(quranSettings), verseRange)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<ResultHolder>() {
          @Override
          public void onSuccess(@NonNull ResultHolder result) {
            if (getTranslationScreen() != null) {
              getTranslationScreen()
                  .setVerses(result.getTranslations(), result.getAyahInformation());
            }
          }

          @Override
          public void onError(@NonNull Throwable e) {
          }
        }));
  }

  public interface TranslationScreen {
    void setVerses(@NonNull LocalTranslation[] translations, @NonNull List<QuranAyahInfo> verses);
  }
}
