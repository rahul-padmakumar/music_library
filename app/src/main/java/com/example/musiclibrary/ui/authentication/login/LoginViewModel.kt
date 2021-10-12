package com.example.musiclibrary.ui.authentication.login

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musiclibrary.datastore.UserPreferences
import com.example.musiclibrary.models.Resource
import com.example.musiclibrary.models.UserModel
import com.example.musiclibrary.repos.authentication.AuthenticationRepo
import kotlinx.coroutines.launch

class LoginViewModel(private val authenticationRepo: AuthenticationRepo,
                     private val dataStore: DataStore<Preferences>): ViewModel(){

    val loginResponseLiveData = MutableLiveData<Resource<UserModel>>()

    fun validateAndLogin(userName: String?, password: String?){
        if(validate(userName, password)){
            if (userName != null && password != null) {
                login(userName, password)
            }
        }
    }

    private fun login(userName: String, password: String){
        viewModelScope.launch {
            loginResponseLiveData.postValue(Resource.Progress())
            val userModel = authenticationRepo.getUserInfo(userName, password)
            if(userModel == null){
                loginResponseLiveData.postValue(Resource.Failure(errorMessage = "User not found"))
            } else {
                UserPreferences.setUserID(dataStore, userModel.id)
                loginResponseLiveData.postValue(Resource.Success(userModel))
            }
        }
    }

    private fun validate(userName: String?, password: String?): Boolean{
        return when{
            !isUserNameValid(userName) -> {
                loginResponseLiveData.postValue(Resource.Failure(errorMessage = "Invalid userName"))
                false
            }
            !isPasswordValid(password) -> {
                loginResponseLiveData.postValue(Resource.Failure(errorMessage = "Invalid password"))
                false
            }
            else -> true
        }
    }

    private fun isUserNameValid(userName: String?): Boolean{
        return userName != null && userName.trim().isNotEmpty()
    }

    private fun isPasswordValid(password: String?): Boolean{
        return password != null && password.trim().isNotEmpty()
    }
}