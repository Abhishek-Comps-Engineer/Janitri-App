package com.org.janitri.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vitals: VitalsEntity)

    @Query("SELECT * FROM vitals ORDER BY timestamp DESC")
    fun observeVitals(): Flow<List<VitalsEntity>>
}
