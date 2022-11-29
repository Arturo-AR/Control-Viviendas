package com.segared.controlviviendas.usecases.complaints.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segared.controlviviendas.usecases.complaints.domain.UploadComplaintUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComplaintsViewModel @Inject constructor(
    private val uploadComplaintUseCase: UploadComplaintUseCase
) : ViewModel() {

    private val _complaint = MutableLiveData<String>()
    val complaint: LiveData<String> = _complaint

    private val _uploaded = MutableLiveData<Boolean>()
    val uploaded: LiveData<Boolean> = _uploaded

    private val _anonymous = MutableLiveData<Boolean>()
    val anonymous: LiveData<Boolean> = _anonymous


    fun uploadComplaint() {
        viewModelScope.launch {
            val result = uploadComplaintUseCase.invoke(
                complain = _complaint.value ?: "",
                userId = 1,
                anonymous = if (_anonymous.value == true) 1 else 0 // Anonymous 1, Not Anonymous 0
            )
            _uploaded.value = result
        }
    }

    fun onChangeComplaint(complaint: String) {
        _complaint.value = complaint
    }

    fun cleanComplaint() {
        _complaint.value = ""
    }

    fun changeAnonymous(anonymous: Boolean) {
        _anonymous.value = anonymous
    }

    fun resetUploaded() {
        _uploaded.value = false
    }

}