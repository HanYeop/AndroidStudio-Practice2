package com.hanyeop.datastoreex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.hanyeop.datastoreex.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val Context.dataStore:
            DataStore<Preferences> by preferencesDataStore(name = "settings")
    private val stringKey = "key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 데이터바인딩
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        lifecycleScope.launch {
            load().collect {
                binding.SavedText.text = it
            }
        }

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                save(binding.editView.text.toString())
            }
        }
    }

    // 데이터 저장
    private suspend fun save(value: String){
        val key = stringPreferencesKey(stringKey)
        dataStore.edit {
            it[key] = value
        }
    }

    // 데이터 불러오기
    private suspend fun load() : Flow<String> {
        val key = stringPreferencesKey(stringKey)
        return dataStore.data.catch { e ->
            if (e is IOException) {
                emit(emptyPreferences())
            } else {
                throw e
            }
        }.map {
            it[key] ?: "기본 텍스트입니다."
        }
    }
}