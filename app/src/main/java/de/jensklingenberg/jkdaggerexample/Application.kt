package de.jensklingenberg.jkdaggerexample

import android.app.Application
import de.jensklingenberg.jkdaggerexample.di.*

class App:Application(){


    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppComponent

    }

    fun initializeDagger() {
        appComponent = DaggerAppComponent.builder() //The DaggerAppComponent will be generated when you build the project
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