package com.youtwo.dagger2sample.screens.common.activitys;

import android.support.annotation.UiThread;
import android.support.v4.app.FragmentActivity;
import com.youtwo.dagger2sample.App;
import com.youtwo.dagger2sample.di.application.AppComponent;
import com.youtwo.dagger2sample.di.controller.ControllerComponent;
import com.youtwo.dagger2sample.di.controller.ControllerModule;

/**
 * Created by Bill on 2017/8/18.
 */

public abstract class BaseActivity extends FragmentActivity {

  private boolean mIsControllerComponentUsed = false;

  /**
   * @return controller injector of type {@link ControllerComponent}
   */
  @UiThread
  protected ControllerComponent getControllerComponent() {
    if (mIsControllerComponentUsed) {
      throw new IllegalStateException("must not use ControllerComponent more than once");
    }
    mIsControllerComponentUsed = true;
    return getApplicationComponent()
        .controllerBuilder()
        .ControllerModule(new ControllerModule(this))
        .build();
  }

  protected AppComponent getApplicationComponent() {
    return ((App) getApplication()).getApplicationComponent();
  }
}
