package com.org.janitri.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [VitalsEntity::class],
    version = 1
)
abstract class PregnancyDatabase : RoomDatabase() {
    abstract fun vitalsDao(): VitalsDao
}
