package com.org.janitri.data.repository

import com.org.janitri.data.local.VitalsDao
import com.org.janitri.data.local.VitalsEntity
import javax.inject.Inject

class VitalsRepository @Inject constructor(
    private val dao: VitalsDao
) {
    val vitalsFlow = dao.observeVitals()

    suspend fun addVitals(v: VitalsEntity) {
        try {
            dao.insert(v)
        } catch (e: Exception) {
            throw RuntimeException("Failed to save vitals")
        }
    }
}
