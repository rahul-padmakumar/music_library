package com.example.musiclibrary.di

import android.content.Context
import com.example.musiclibrary.MusicLibraryApplication
import com.example.musiclibrary.ui.authentication.LoginFragment
import com.example.musiclibrary.ui.dashboard.DashboardFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,
    AuthenticationModule::class,
    DashboardModule::class,
    ViewModelModule::class,
    SubcomponentModules::class])
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(dashboardFragment: DashboardFragment)

    fun loginSubComponent(): LoginSubComponent.LoginBuilder
}
