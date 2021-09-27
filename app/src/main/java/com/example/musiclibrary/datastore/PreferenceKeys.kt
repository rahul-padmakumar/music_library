package com.example.musiclibrary.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys {
    val LOGGED_IN_USER_ID = intPreferencesKey("music_library_logged_in_user_id")
}
