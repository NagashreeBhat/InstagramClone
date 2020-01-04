package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("RFUuZSzlrU9dHnLskscSwL8vzaLFCrjFuhk6KfCK")
                .clientKey("SN6nE6LJdem639xDjL8M9lUlVv7Ebho60nigrsLo")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }

}
