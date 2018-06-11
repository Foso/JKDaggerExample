package de.jensklingenberg.jkdaggerexample.di

import android.arch.lifecycle.ViewModel
import dagger.Component
import de.jensklingenberg.jkdaggerexample.MainActivity

import javax.inject.Singleton

@Component(modules = [(AppModule::class), (RemoteModule::class)])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity) {}
}
