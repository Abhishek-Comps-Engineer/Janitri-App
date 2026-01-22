package com.org.janitri.ui.vitals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.janitri.data.local.VitalsEntity
import com.org.janitri.data.repository.VitalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VitalsViewModel @Inject constructor(
    private val repo: VitalsRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<VitalsUiState>(VitalsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repo.vitalsFlow.collect { list ->
                _uiState.value =
                    if (list.isEmpty())
                        VitalsUiState.Empty
                    else
                        VitalsUiState.Content(list)
            }
        }
    }

    fun addVitals(
        s: String, d: String, hr: String,
        w: String, k: String
    ) {
        val error =
            VitalsValidator.validate(s, d, hr, w, k)

        if (error != null) {
            _uiState.value = VitalsUiState.Error(error)
            return
        }

        viewModelScope.launch {
            repo.addVitals(
                VitalsEntity(
                    systolic = s.toInt(),
                    diastolic = d.toInt(),
                    heartRate = hr.toInt(),
                    weight = w.toFloat(),
                    babyKicks = k.toInt()
                )
            )
        }
    }
}
