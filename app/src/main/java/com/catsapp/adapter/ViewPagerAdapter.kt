package com.catsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fa : FragmentActivity, private val listFrag : List<Fragment>) : FragmentStateAdapter(fa) {
    override fun getItemCount() = listFrag.size



    override fun createFragment(position: Int): Fragment {
        return listFrag[position]
    }
}