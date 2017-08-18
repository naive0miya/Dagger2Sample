package com.youtwo.dagger2sample.di.application;

import android.content.Context;
import android.content.SharedPreferences;
import com.youtwo.dagger2sample.common.Constants;
import com.youtwo.dagger2sample.common.settings.SettingsManager;
import com.youtwo.dagger2sample.common.settings.sharedpreferences.SharedPrefsSettingsEntryFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by Bill on 2017/8/18.
 */
@Module
public class SettingsModule {

  @Provides
  @ApplicationScope
  SettingsManager settingsManager(@Named("appContext")Context application) {
    SharedPreferences sharedPreferences = application
        .getSharedPreferences(Constants.SHARED_PREFS_FILE, Context.MODE_PRIVATE);
    return new SettingsManager(new SharedPrefsSettingsEntryFactory(sharedPreferences));
  }

}
