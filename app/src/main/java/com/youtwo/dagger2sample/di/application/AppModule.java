package com.youtwo.dagger2sample.di.application;

import android.app.Application;
import android.content.Context;
import com.youtwo.dagger2sample.di.controller.ControllerComponent;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by Bill on 2017/8/18.
 */
@Module(subcomponents  = {ControllerComponent.class})
public class AppModule {

  @Provides
  @ApplicationScope
  @Named("appContext")
  Context context(Application application) {

    return application;
  }

  @Provides
  @ApplicationScope
  EventBus eventBus() {
    return EventBus.getDefault();
  }

}
