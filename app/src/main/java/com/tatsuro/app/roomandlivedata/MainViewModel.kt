package com.tatsuro.app.roomandlivedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val dao = AppDatabase.getDatabase(getApplication()).userDao()

    val users = dao.loadAll()

    fun insertUser() {
        val user = User(name = "Tatsuro")
        viewModelScope.launch(context = Dispatchers.IO) {
            dao.insert(user)
        }
    }
}
