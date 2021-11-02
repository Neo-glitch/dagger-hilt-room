package com.neo.daggerhiltroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.neo.daggerhiltroomdb.databinding.ActivityMainBinding
import com.neo.daggerhiltroomdb.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val mViewModel: MainActivityViewModel by lazy { ViewModelProvider(this)[MainActivityViewModel::class.java]}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        initVM()

        mainBinding.saveButton.setOnClickListener {
            val userEntity = UserEntity(name = mainBinding.enterDescriptionEditText.text.toString())
            mViewModel.insertRecord(userEntity)
            mainBinding.enterDescriptionEditText.setText("")
        }
    }

    private fun initVM() {
        mViewModel.getRecordsObserver().observe(this, object : Observer<List<UserEntity>> {
            override fun onChanged(t: List<UserEntity>?) {
                mainBinding.resultTextView.text = ""
                t?.forEach {
                    mainBinding.resultTextView.append("${it.name} \n")
                }
            }
        })
    }
}