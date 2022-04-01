package com.catsapp.data.repository.remote.model

import io.realm.RealmObject

open class CatsFavItem(
    var id : Long? = 0,
    var imageUrl : String? = null,
    var name : String? = null,
    var isFav : Boolean? = false
) : RealmObject()
