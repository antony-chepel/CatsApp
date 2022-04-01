package com.catsapp.common

import androidx.fragment.app.Fragment
import com.catsapp.screens.AllCatsFragment
import com.catsapp.screens.FavCatsFragment

object Utils {

    val listFrag = listOf<Fragment>(
        AllCatsFragment.newInstance(),
        FavCatsFragment.newInstance()
    )

    val listTextFrag = listOf<String>(
        "All cats",
        "Favourites"
    )
}