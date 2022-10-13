package com.android.people.di

import android.content.Context
import androidx.room.Room
import com.android.people.data.local.VirginMoneyUserDatabase
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
    fun provideDatabase(@ApplicationContext context: Context): VirginMoneyUserDatabase {
        return Room.databaseBuilder(context, VirginMoneyUserDatabase::class.java, "virgin_money_user_database").build()
    }

    @Provides
    @Singleton
    fun providesDao(virginMoneyDatabase: VirginMoneyUserDatabase) = virginMoneyDatabase.usersDao()
}
