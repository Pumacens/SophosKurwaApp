package com.example.sophos.ViewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sophos.ARetrofitConfig.RetrofitConfig
import com.example.sophos.Data.Model.LoginResponse
import com.example.sophos.Data.Network.API.LoginAPIClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LoginViewModel: ViewModel() {

    private var _logInResponse: MutableLiveData<LoginResponse?> = MutableLiveData()
    val apiLoginResponse: LiveData<LoginResponse?>
        get() = _logInResponse

    fun searchByUser(email: String, password: String) {

    }

    // LOGIN CON DATOS DE USUARIO //
    fun login(email: String, password: String, activity: AppCompatActivity){

        val apiInterface =  RetrofitConfig.getRetrofit().create(LoginAPIClient::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            val call = apiInterface.getLoginByUserandPass(email, password)

            if (call.isSuccessful) {
                val loginResponse = call.body()
                _logInResponse.postValue(loginResponse)
                _logInResponse.postValue(
                    LoginResponse(
                        id = "Test",
                        uname = "Test",
                        ulastname = " Test",
                        uaccess = true,
                        uadmin = true
                    )
                )
            }
        }
    }
}