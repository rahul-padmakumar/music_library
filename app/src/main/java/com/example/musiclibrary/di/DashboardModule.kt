package com.example.musiclibrary.di

import androidx.lifecycle.ViewModel
import com.example.musiclibrary.di.scope.ViewModelKey
import com.example.musiclibrary.ui.dashboard.DashboardViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class DashboardModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel
}