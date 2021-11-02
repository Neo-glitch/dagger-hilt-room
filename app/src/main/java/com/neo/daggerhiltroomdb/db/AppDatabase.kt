package com.neo.daggerhiltroomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version =1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getDao(): AppDao

    companion object{
        private var dbInstance: AppDatabase? = null

        fun getDbInstance(context: Context): AppDatabase{
            if(dbInstance == null){
                dbInstance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "app_hilt_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return dbInstance!!
        }
    }
}