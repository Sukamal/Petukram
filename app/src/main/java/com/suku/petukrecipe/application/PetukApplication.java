package com.suku.petukrecipe.application;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;
import com.suku.petukrecipe.R;

/**
 * Created by SukamalD on 25-01-2018.
 */

public class PetukApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, getString(R.string.admob_app_id));
    }
}
