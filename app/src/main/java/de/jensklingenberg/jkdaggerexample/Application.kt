package de.jensklingenberg.jkdaggerexample

import android.app.Application
import de.jensklingenberg.jkdaggerexample.di.AppComponent
import de.jensklingenberg.jkdaggerexample.di.AppModule
import de.jensklingenberg.jkdaggerexample.di.DaggerAppComponent
import de.jensklingenberg.jkdaggerexample.di.RemoteModule

class App:Application(){


    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppComponent

    }

    fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .remoteModule(RemoteModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        initializeDagger()
    }


}