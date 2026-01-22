package com.org.janitri.di

import android.content.Context
import androidx.room.Room
import com.org.janitri.data.local.PregnancyDatabase
import com.org.janitri.data.local.VitalsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDb(
        @ApplicationContext ctx: Context
    ): PregnancyDatabase =
        Room.databaseBuilder(
            ctx,
            PregnancyDatabase::class.java,
            "vitals_db"
        ).build()

    @Provides
    fun provideDao(db: PregnancyDatabase): VitalsDao =
        db.vitalsDao()
}
