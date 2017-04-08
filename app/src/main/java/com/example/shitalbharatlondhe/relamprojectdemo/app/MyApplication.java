package com.example.shitalbharatlondhe.relamprojectdemo.app;

import android.app.Application;
import android.content.Context;
import io.realm.Realm;
import io.realm.RealmConfiguration.Builder;

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Realm.setDefaultConfiguration(new Builder((Context) this).name(Realm.DEFAULT_REALM_NAME).schemaVersion(0).deleteRealmIfMigrationNeeded().build());
    }
}
