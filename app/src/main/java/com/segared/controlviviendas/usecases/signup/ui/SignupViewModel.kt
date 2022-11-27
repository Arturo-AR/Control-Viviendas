package com.segared.controlviviendas.usecases.signup.ui

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.signup.domain.SignupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val signupUseCase: SignupUseCase) : ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _mothersLastName = MutableLiveData<String>()
    val mothersLastName: LiveData<String> = _mothersLastName

    private val _street = MutableLiveData<String>()
    val street: LiveData<String> = _street

    private val _number = MutableLiveData<String>()
    val number: LiveData<String> = _number

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> = _phone

    private val _inePhoto = MutableLiveData<Bitmap>()
    val inePhoto: LiveData<Bitmap> = _inePhoto

    private val _user = MutableLiveData<String>()
    val user: LiveData<String> = _user

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onChangeTextFields(
        name: String,
        lastName: String,
        motherLastName: String,
        street: String,
        number: String,
        phone: String,
        user: String,
        password: String
    ) {
        _name.value = name
        _lastName.value = lastName
        _mothersLastName.value = motherLastName
        _street.value = street
        _number.value = number
        _phone.value = phone
        _user.value = user
        _password.value = password
    }


    fun selectIneImage(image: Bitmap?) {
        _inePhoto.value = image
    }

    fun signUpNewUser(
        name: String,
        lastName: String,
        mothersLastName: String,
        street: String,
        number: String,
        phone: String,
        user: String,
        password: String,
        inePhoto: Bitmap?,
        onError: () -> Unit,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = signupUseCase.invoke(
                    name = name,
                    lastName = lastName,
                    mothersLastName = mothersLastName,
                    street = street,
                    number = number,
                    phone = phone,
                    inePhoto = inePhoto,
                    user = user,
                    password = password,
                    typeId = 2
                )
                if (response.responseCode == Constants.SUCCESS_CODE) {
                    onSuccess()
                } else {
                    onError()
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                onError()
            }
        }
    }
}