package com.youtwo.dagger2sample.screens.common.dialogs.prompt;


import com.youtwo.dagger2sample.screens.common.dialogs.prompt.PromptViewMvc.PromptViewMvcListener;
import com.youtwo.dagger2sample.screens.common.mvcviews.ObservableViewMvc;

public interface PromptViewMvc extends ObservableViewMvc<PromptViewMvcListener> {

    public interface PromptViewMvcListener {
        void onPositiveButtonClicked();
        void onNegativeButtonClicked();
    }

    void setTitle(String title);
    void setMessage(String message);
    void setPositiveButtonCaption(String positiveButtonCaption);
    void setNegativeButtonCaption(String negativeButtonCaption);

}
