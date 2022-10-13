package com.android.rooms.di

import android.content.Context
import androidx.room.Room
import com.android.rooms.data.local.VirginMoneyRoomsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): VirginMoneyRoomsDatabase {
        return Room.databaseBuilder(
            context,
            VirginMoneyRoomsDatabase::class.java,
            "virgin_money_room_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providesDao(virginMoneyDatabase: VirginMoneyRoomsDatabase) = virginMoneyDatabase.roomsDao()
}
