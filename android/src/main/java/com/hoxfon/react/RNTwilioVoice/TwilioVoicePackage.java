package com.hoxfon.react.RNTwilioVoice;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class TwilioVoicePackage implements ReactPackage {

    private boolean mShouldAskForPermission;
    private String mBaseUrl;
    private String mS3Url;
    public TwilioVoicePackage() {
        mShouldAskForPermission = true;
        mBaseUrl = "";
        mS3Url = "";
    }

    public TwilioVoicePackage(final String baseUrl, final String s3Url) {
        mBaseUrl = baseUrl;
        mS3Url = s3Url;
    }

    public TwilioVoicePackage(boolean shouldAskForPermissions) {
        mShouldAskForPermission = shouldAskForPermissions;
    }
    // Deprecated in RN 0.47.0
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new TwilioVoiceModule(reactContext, mShouldAskForPermission, mBaseUrl, mS3Url));
        return modules;
    }
}
