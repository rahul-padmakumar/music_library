package com.example.musiclibrary.ui.authentication

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musiclibrary.datastore.UserPreferences
import com.example.musiclibrary.extensions.isValidPassWord
import com.example.musiclibrary.extensions.isValidUserName
import com.example.musiclibrary.models.Resource
import com.example.musiclibrary.models.UserModel
import com.example.musiclibrary.repos.authentication.AuthenticationRepo
import com.example.musiclibrary.repos.library.LibraryRepo
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authenticationRepo: AuthenticationRepo,
    private val libraryRepo: LibraryRepo,
    val dataStore: DataStore<Preferences>): ViewModel() {

    val liveData = MutableLiveData<Resource<UserModel>>()

    fun validateAndSignUpUser(userModel: UserModel){
        liveData.postValue(Resource.Progress())
        if(validate(userModel)){
            signUpUser(userModel)
        }
    }

    private fun signUpUser(userModel: UserModel){
        viewModelScope.launch {
            try {
                val id = authenticationRepo.insertUser(userModel).toInt()
                val insertedUserModel = userModel.copy(id = id)
                UserPreferences.setUserID(dataStore, id)
                createLibrary(insertedUserModel)
            } catch (e: Exception){
                liveData.postValue(Resource.Failure(errorMessage = e.message))
            }
        }
    }

    private fun createLibrary(userModel: UserModel) {
        viewModelScope.launch {
            try {
                libraryRepo.createLibrary(userModel.id)
                liveData.postValue(Resource.Success(userModel))
            } catch (e: Exception){
                liveData.postValue(Resource.Failure(errorMessage = e.message))
            }
        }
    }

    private fun validate(userModel: UserModel): Boolean{
        return when{
            !userModel.name.isValidUserName() -> {
                liveData.postValue(Resource.Failure(errorMessage = "user name is invalid"))
                false
            }
            !userModel.password.isValidPassWord() -> {
                liveData.postValue(Resource.Failure(errorMessage = "password is invalid"))
                false
            }
            userModel.address.houseName.trim().isEmpty() ||
            userModel.address.streetName.trim().isEmpty() ||
            userModel.address.city.trim().isEmpty() ||
            userModel.address.state.trim().isEmpty() ||
            userModel.address.country.trim().isEmpty() -> {
                liveData.postValue(Resource.Failure(errorMessage = "Address is invalid"))
                false
            }
            else -> true
        }
    }
}