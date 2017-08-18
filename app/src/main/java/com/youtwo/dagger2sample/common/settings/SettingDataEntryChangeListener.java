package com.youtwo.dagger2sample.common.settings;


public interface SettingDataEntryChangeListener<T> {

    void onValueChanged(SettingDataEntry settingDataEntry, T value);

}
