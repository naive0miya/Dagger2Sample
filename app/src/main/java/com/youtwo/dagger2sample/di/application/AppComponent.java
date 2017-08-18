package com.youtwo.dagger2sample.di.application;

import com.youtwo.dagger2sample.App;
import com.youtwo.dagger2sample.di.controller.ControllerComponent;
import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Bill on 2017/8/18.
 */
@ApplicationScope
@Component(modules = {
    AppModule.class,
    SettingsModule.class,
})
public interface AppComponent {

  ControllerComponent.Builder controllerBuilder();

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(App app);

    AppComponent build();
  }
}
