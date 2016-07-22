package com.keyee.pdfview;

import android.content.Intent;

import com.artifex.mupdfdemo.MuPDFActivity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.net.Uri;
import android.util.Log;

import java.io.File;

/**
 * Created by guerra on 20/07/16.
 */
public class PDFViewUtilManager extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "RCTMuPDFViewUtilAndroid";

    public PDFViewUtilManager(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() { return REACT_CLASS; }

    @ReactMethod
    public void openFile(String uri, final Promise promise) {

        Intent intent = new Intent(getCurrentActivity(), MuPDFActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        Log.w("RCTMuPDF", "File: "+uri);
        intent.setData(Uri.fromFile(new File(uri)));
        getCurrentActivity().startActivity(intent);
        promise.resolve(true);
    }
}
