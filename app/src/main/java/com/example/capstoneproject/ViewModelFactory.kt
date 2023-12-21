package com.example.capstoneproject

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.capstoneproject.database.di.Injection
//import com.example.capstoneproject.database.di.Injection
import com.example.capstoneproject.database.repository.Repository
import com.example.capstoneproject.view.MainViewModel
import com.example.capstoneproject.view.fragment.detail.DetailViewModel
import com.example.capstoneproject.view.fragment.ui.home.HomeViewModel
import com.example.capstoneproject.view.fragment.ui.search.SearchModel
import com.example.capstoneproject.view.login.LoginViewModel
import com.example.capstoneproject.view.register.RegisterViewModel
import com.example.capstoneproject.view.setting.SettingViewModel

class ViewModelFactory(private val repository: Repository):
    ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(SettingViewModel::class.java) -> {
                SettingViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            modelClass.isAssignableFrom(SearchModel::class.java) -> {
                SearchModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(repository) as T
            }
            else -> throw IllegalAccessException("Unknown ViewModel Class: "+ modelClass.name)
        }
    }
    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory{
            if (INSTANCE == null){
                synchronized(ViewModelFactory::class.java){
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}