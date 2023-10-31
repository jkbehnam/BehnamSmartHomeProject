package com.example.smarthomeproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response

class LoginViewModel : ViewModel() {

    public var respons = MutableLiveData<Int>(0)
    fun login(username: String, password: String) {
        respons.value = respons.value?.plus(1)
        val loginService = RetrofitClient.retrofit.create(ApiService::class.java)

        viewModelScope.launch {
            try {
                // ارسال درخواست به کمک کوروتین
                val response = withContext(Dispatchers.IO) {
                    loginService.login(username, password)
                }

                if (response.isSuccessful) {
                    // در صورت موفقیت، مقدار LiveData را به‌روز کنید
                    respons.value = 1
                } else {
                    // در صورت ناموفقیت، مقدار LiveData را به‌روز کنید
                    respons.value = 2
                }
            } catch (e: Exception) {
                // در صورت خطا، مقدار LiveData را به‌روز کنید
                respons.value = 3
            }
        }

    }

}