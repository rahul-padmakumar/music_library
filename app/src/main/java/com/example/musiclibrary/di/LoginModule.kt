package com.example.musiclibrary.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import com.example.musiclibrary.di.scope.ViewModelKey
import com.example.musiclibrary.repos.authentication.AuthenticationRepo
import com.example.musiclibrary.ui.authentication.login.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class LoginModule {

    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun loginViewModelProvider(authenticationRepo: AuthenticationRepo, dataStore: DataStore<Preferences>): ViewModel {
        return LoginViewModel(authenticationRepo, dataStore)
    }
}