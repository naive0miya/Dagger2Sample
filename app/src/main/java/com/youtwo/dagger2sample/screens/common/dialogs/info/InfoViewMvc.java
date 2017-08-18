package com.youtwo.dagger2sample.screens.common.dialogs.info;


import com.youtwo.dagger2sample.screens.common.dialogs.info.InfoViewMvc.InfoViewMvcListener;
import com.youtwo.dagger2sample.screens.common.mvcviews.ObservableViewMvc;

public interface InfoViewMvc extends ObservableViewMvc<InfoViewMvcListener> {

    public interface InfoViewMvcListener {
        void onDismissClicked();
    }

    void setTitle(String title);
    void setMessage(String message);
    void setDismissCaption(String dismissCaption);

}
