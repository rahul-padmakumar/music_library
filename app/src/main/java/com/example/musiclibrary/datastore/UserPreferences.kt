package com.example.musiclibrary.datastore

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit

class UserPreferences {

    companion object{

        suspend fun setUserID(context: Context, userId: Int){
            context.dataStore.edit {
                it[PreferenceKeys.LOGGED_IN_USER_ID] = userId
            }
        }

        fun getUserId(context: Context): Flow<Int>{
            return context.dataStore.data.map { preferences ->
                preferences[PreferenceKeys.LOGGED_IN_USER_ID] ?: 0
            }
        }
    }
}