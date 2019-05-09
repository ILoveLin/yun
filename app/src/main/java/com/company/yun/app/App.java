package com.company.yun.app;

import android.app.Application;

/**
 * Created by Lovelin on 2019/4/27
 * <p>
 * Describe:
 */
public class App extends Application {

    private static App app;
    public static String AppFilePath = "app";

    public App() {
        app = this;
    }

    public static synchronized App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * 做一些sdk等等的init
         */
    }




}










