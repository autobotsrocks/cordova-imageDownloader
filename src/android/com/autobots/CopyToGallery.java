package com.autobots;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.ContentValues;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;

public class CopyToGallery extends CordovaPlugin {
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("copy")) {
            final String imagePath = args.getString(0);
            cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    ContentValues values = new ContentValues();
                    values.put(Images.Media.DATE_TAKEN, System.currentTimeMillis());
                    values.put(Images.Media.MIME_TYPE, "image/jpeg");
                    values.put(MediaStore.MediaColumns.DATA, imagePath);
                    cordova.getActivity().getContentResolver().insert(Images.Media.EXTERNAL_CONTENT_URI, values);
                    callbackContext.success();
                }
            });
        }
        return true;
    }
}