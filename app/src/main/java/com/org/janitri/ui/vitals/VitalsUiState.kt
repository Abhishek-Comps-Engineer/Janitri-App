package com.org.janitri.ui.vitals

import com.org.janitri.data.local.VitalsEntity

sealed class VitalsUiState {
    object Loading : VitalsUiState()
    object Empty : VitalsUiState()
    data class Content(val list: List<VitalsEntity>) : VitalsUiState()
    data class Error(val message: String) : VitalsUiState()
}
