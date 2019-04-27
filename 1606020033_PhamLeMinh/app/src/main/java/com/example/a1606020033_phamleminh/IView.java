package com.example.a1606020033_phamleminh;

import android.graphics.Bitmap;

import org.json.JSONArray;

public interface IView {
    void onRequestSuccess(Bitmap bitmap);
    void onGetDataSuccess(JSONArray jsonArray);
}
