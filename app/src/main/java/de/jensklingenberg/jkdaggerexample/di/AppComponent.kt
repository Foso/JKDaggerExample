package de.jensklingenberg.jkdaggerexample.di

import dagger.Component
import de.jensklingenberg.jkdaggerexample.MainActivity

import javax.inject.Singleton

@Component(modules = [(AppModule::class), (RemoteModule::class)])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity) {}
}
