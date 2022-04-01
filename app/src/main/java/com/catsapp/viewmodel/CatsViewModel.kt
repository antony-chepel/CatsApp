package com.catsapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catsapp.data.repository.CatsRepositoryImpl
import com.catsapp.data.repository.remote.model.CatsFavItem
import com.catsapp.data.repository.remote.model.CatsResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.Realm
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val repository: CatsRepositoryImpl,
    private var realm: Realm = Realm.getDefaultInstance()
) : ViewModel() {
    private val _response = MutableLiveData<List<CatsResponseItem>>()
    val catsResponse : LiveData<List<CatsResponseItem>> get() = _response


    private val _favResponse = MutableLiveData<List<CatsFavItem>>()
    val catsFav : LiveData<List<CatsFavItem>> get() =_favResponse


    init {
        getCats()
    }


    private fun getCats() = viewModelScope.launch {
        repository.getCats().let { response ->
            if(response.isSuccessful){
                _response.postValue(response.body())
            } else {
                Log.d("MyLogErrors","getCats : ${response.code()}")
            }

        }
    }


     fun addToFav(){
//        realm.executeTransaction {
//                r : Realm ->
//            val favCat = r.createObject(CatsFavItem::class.java)
//            favCat.isFav = true
//            realm.insertOrUpdate(favCat)
//
//        }

    }

     fun deleteFav(){
//        realm.executeTransaction {
//                r : Realm ->
//            val favCat = r.createObject(CatsFavItem::class.java)
//            favCat.isFav = false
//            realm.insertOrUpdate(favCat)
//
//        }

    }



}