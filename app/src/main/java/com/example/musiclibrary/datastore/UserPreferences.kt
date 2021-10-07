package com.example.musiclibrary.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit

class UserPreferences{

    companion object{

        suspend fun setUserID(dataStore: DataStore<Preferences>, userId: Int){
            dataStore.edit {
                it[PreferenceKeys.LOGGED_IN_USER_ID] = userId
            }
        }

        fun getUserId(dataStore: DataStore<Preferences>): Flow<Int>{
            return dataStore.data.map { preferences ->
                preferences[PreferenceKeys.LOGGED_IN_USER_ID] ?: 0
            }
        }
    }
}