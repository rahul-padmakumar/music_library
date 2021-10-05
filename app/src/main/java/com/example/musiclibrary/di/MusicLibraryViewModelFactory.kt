package com.example.musiclibrary.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class MusicLibraryViewModelFactory @Inject constructor(
    private val viewModelProviders: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        var provider: Provider<out ViewModel>? = viewModelProviders[modelClass]

        if(provider == null){
            for((key, value) in viewModelProviders){
                if(key.isAssignableFrom(modelClass)){
                    provider = value
                    break
                }
            }
        }

        if(provider == null){
            throw IllegalArgumentException("Unknown model class $modelClass")
        }

        try {
            return provider.get() as T
        } catch (e: Exception){
            throw RuntimeException(e)
        }
    }
}