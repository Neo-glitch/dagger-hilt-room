package com.neo.daggerhiltroomdb.di

import android.app.Application
import com.neo.daggerhiltroomdb.db.AppDao
import com.neo.daggerhiltroomdb.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideAppDatabase(context: Application):AppDatabase {
        return AppDatabase.getDbInstance(context)
    }

    @Singleton
    @Provides
    fun provideDao(appDb: AppDatabase): AppDao {
        return appDb.getDao()
    }


}