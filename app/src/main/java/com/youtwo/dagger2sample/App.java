package com.youtwo.dagger2sample;

import android.app.Application;
import com.youtwo.dagger2sample.di.application.AppComponent;
import com.youtwo.dagger2sample.di.application.DaggerAppComponent;

/**
 * Created by Bill on 2017/8/18.
 */

public class App extends Application {

  private AppComponent applicationComponent = createComponent();

  public AppComponent getApplicationComponent() {
    return applicationComponent;
  }

  protected AppComponent createComponent() {
    return DaggerAppComponent.builder()
        .application(this)
        .build();
  }
}
