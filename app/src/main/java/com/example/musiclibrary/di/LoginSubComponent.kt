package com.example.musiclibrary.di

import com.example.musiclibrary.ui.authentication.LoginFragment
import dagger.Subcomponent

@Subcomponent(modules = [LoginModule::class])
interface LoginSubComponent {
    @Subcomponent.Builder
    interface LoginBuilder{
        fun build(): LoginSubComponent
    }

    fun inject(loginFragment: LoginFragment)
}