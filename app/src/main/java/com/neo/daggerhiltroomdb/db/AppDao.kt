package com.neo.daggerhiltroomdb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("select * from user order by id desc")
    fun getRecords(): List<UserEntity>

    @Insert
    fun insertRecord(userEntity: UserEntity)
}