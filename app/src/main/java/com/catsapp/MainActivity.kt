package com.catsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.catsapp.adapter.CatsAdapter
import com.catsapp.adapter.ViewPagerAdapter
import com.catsapp.common.Utils
import com.catsapp.databinding.ActivityMainBinding
import com.catsapp.screens.AllCatsFragment
import com.catsapp.viewmodel.CatsViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init() = with(binding){
        adapter = ViewPagerAdapter(this@MainActivity,Utils.listFrag)
        viewpager.adapter = adapter
        TabLayoutMediator(tabLayout,viewpager){
            tab,pos -> tab.text = Utils.listTextFrag[pos]
        }.attach()

    }


}