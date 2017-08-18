package com.youtwo.dagger2sample.screens.common.dialogs;

import android.support.annotation.UiThread;
import android.support.v4.app.DialogFragment;
import com.youtwo.dagger2sample.App;
import com.youtwo.dagger2sample.di.application.AppComponent;
import com.youtwo.dagger2sample.di.controller.ControllerComponent;
import com.youtwo.dagger2sample.di.controller.ControllerModule;


/**
 * Base class for all dialogs
 */
public abstract class BaseDialog extends DialogFragment {

    private boolean mIsControllerComponentUsed = false;

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mIsControllerComponentUsed) {
            throw new IllegalStateException("must not use ControllerComponent more than once");
        }
        mIsControllerComponentUsed = true;
        return  getApplicationComponent()
            .controllerBuilder()
            .ControllerModule(new ControllerModule(getActivity()))
            .build();
    }

    /**
     * Get this dialog's ID that was supplied with a call to
     * {@link DialogsManager#showRetainedDialogWithId(DialogFragment, String)}
     * @return dialog's ID, or null if none was set
     */
    protected String getDialogId() {
        if (getArguments() == null) {
            return null;
        } else {
            return getArguments().getString(DialogsManager.ARGUMENT_DIALOG_ID);
        }
    }

    protected AppComponent getApplicationComponent() {
        return ((App)getActivity().getApplication()).getApplicationComponent();
    }
}
