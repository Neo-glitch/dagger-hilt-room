package com.neo.daggerhiltroomdb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neo.daggerhiltroomdb.db.RoomRepository
import com.neo.daggerhiltroomdb.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel
@Inject constructor(private val repository: RoomRepository) : ViewModel(){

    lateinit var userData: MutableLiveData<List<UserEntity>>

    init {
        userData = MutableLiveData()
        loadRecords()
    }

    fun getRecordsObserver(): MutableLiveData<List<UserEntity>> {
        return userData
    }

    fun loadRecords(){
        val list = repository.getRecords()
        userData.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity){
        repository.insertRecord(userEntity)
        loadRecords()
    }
}