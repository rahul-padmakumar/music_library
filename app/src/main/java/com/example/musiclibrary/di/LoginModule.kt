package com.example.musiclibrary.di

import androidx.lifecycle.ViewModel
import com.example.musiclibrary.datasource.db.entities.Address
import com.example.musiclibrary.di.scope.ViewModelKey
import com.example.musiclibrary.models.UserModel
import com.example.musiclibrary.repos.AuthenticationRepo
import com.example.musiclibrary.ui.authentication.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class LoginModule {

    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun loginViewModelProvider(authenticationRepo: AuthenticationRepo): ViewModel {
        return LoginViewModel(authenticationRepo)
    }
}