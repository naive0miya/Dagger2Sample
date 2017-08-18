package com.youtwo.dagger2sample.screens.main.activity;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.youtwo.dagger2sample.R;
import com.youtwo.dagger2sample.screens.common.activitys.BaseActivity;
import com.youtwo.dagger2sample.screens.common.dialogs.DialogsFactory;
import com.youtwo.dagger2sample.screens.common.dialogs.DialogsManager;

import javax.inject.Inject;

public class MainActivity extends BaseActivity  {

  @Inject
  DialogsManager mDialogsManager;
  @Inject
  DialogsFactory mDialogsFactory;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getControllerComponent().inject(this);
    Button button = (Button) findViewById(R.id.btn_show_dialog);
    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        onShowDialogClicked();
      }
    });
  }

  public void onShowDialogClicked() {
    DialogFragment dialog = mDialogsFactory.newInfoDialog(
        getString(R.string.dialog_title),
        getString(R.string.dialog_message),
        getString(R.string.dialog_button_caption));
    mDialogsManager.showRetainedDialogWithId(dialog, null);
  }
}
