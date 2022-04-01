package com.catsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catsapp.data.repository.CatsRepositoryImpl
import com.catsapp.data.repository.remote.model.CatsFavItem
import com.catsapp.data.repository.remote.model.CatsResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.Realm
import javax.inject.Inject

@HiltViewModel
class FavCatsViewModel @Inject constructor(
    private var realm: Realm = Realm.getDefaultInstance() ,private val repository: CatsRepositoryImpl,

    ) : ViewModel() {
    private val _response = MutableLiveData<List<CatsResponseItem>>()
    val catsResponse : LiveData<List<CatsResponseItem>> get() = _response

//
//    private val _favResponse = MutableLiveData<List<CatsFavItem>>()
//    val catsFav : LiveData<List<CatsFavItem>> get() =_favResponse


    init {
        getAllFavCats()

    }

    private fun getAllFavCats(){
//        val favCats = realm.where(CatsFavItem::class.java).equalTo("isFav",true).findAll()
//        _favResponse.value = favCats.subList(0,favCats.size)
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