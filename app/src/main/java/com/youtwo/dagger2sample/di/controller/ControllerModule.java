package com.youtwo.dagger2sample.di.controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.youtwo.dagger2sample.screens.common.dialogs.DialogsFactory;
import com.youtwo.dagger2sample.screens.common.dialogs.DialogsManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by Bill on 2017/8/18.
 */
@Module()
public class ControllerModule {

  private final FragmentActivity mActivity;

  public ControllerModule(FragmentActivity activity) {
    mActivity = activity;
  }

  @Provides
  @Named("activityContext")
  Context context() {
    return mActivity;
  }

  @Provides
  Activity activity() {
    return mActivity;
  }

  @Provides
  FragmentManager fragmentManager() {
    return mActivity.getSupportFragmentManager();
  }

  @Provides
  DialogsManager dialogsManager(FragmentManager fragmentManager) {
    return new DialogsManager(fragmentManager);
  }

  @Provides
  DialogsFactory dialogsFactory() {
    return new DialogsFactory();
  }
}
