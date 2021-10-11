package com.example.musiclibrary.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import com.example.musiclibrary.di.scope.ViewModelKey
import com.example.musiclibrary.repos.authentication.AuthenticationRepo
import com.example.musiclibrary.repos.library.LibraryRepo
import com.example.musiclibrary.ui.authentication.SignUpViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class SignUpModule {

    @Provides
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    fun signUpViewModelProvider(
        authenticationRepo: AuthenticationRepo,
        libraryRepo: LibraryRepo,
        dataStore: DataStore<Preferences>): ViewModel{
        return SignUpViewModel(authenticationRepo, libraryRepo, dataStore)
    }
}