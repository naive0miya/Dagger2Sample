package com.youtwo.dagger2sample.di.controller;

import com.youtwo.dagger2sample.screens.common.activitys.BaseActivity;
import com.youtwo.dagger2sample.screens.common.dialogs.info.InfoDialog;
import com.youtwo.dagger2sample.screens.common.dialogs.prompt.PromptDialog;
import com.youtwo.dagger2sample.screens.main.activity.MainActivity;
import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * Created by Bill on 2017/8/18.
 */

@Subcomponent(modules = ControllerModule.class)
public interface ControllerComponent {

  void inject(MainActivity mainActivity);
  void inject(InfoDialog infoDialog);
  void inject(PromptDialog promptDialog);

  @Subcomponent.Builder
  interface Builder {

    Builder ControllerModule(ControllerModule controllerModule);

    ControllerComponent build();
  }
}
