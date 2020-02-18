package com.cred.daggerdemoapp;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application application;

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    AppModule(Application application) {
        this.application = application;
    }
}
