package com.android.virginmoney.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.android.virginmoney.data.cache.VirginMoneyDatabase
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
    fun provideDatabase(@ApplicationContext context: Context): VirginMoneyDatabase {
        return Room.databaseBuilder(context, VirginMoneyDatabase::class.java, "virgin_money_database").build()
    }

    @Provides
    @Singleton
    fun providesDao(virginMoneyDatabase: VirginMoneyDatabase) = virginMoneyDatabase.virginMoneyDao()

    @Provides
    @Singleton
    fun providesSharedPrefs(
        @ApplicationContext applicationContext: Context
    ): SharedPreferences {
        return applicationContext.getSharedPreferences("virgin_money_prefs", Context.MODE_PRIVATE)
    }
}
