package com.catsapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.catsapp.adapter.CatsAdapter
import com.catsapp.adapter.Listener
import com.catsapp.databinding.FavCatsFragmentBinding
import com.catsapp.viewmodel.FavCatsViewModel

class FavCatsFragment : Fragment(),Listener {
    private lateinit var binding : FavCatsFragmentBinding
    private lateinit var adapter : CatsAdapter
    private val viewModel : FavCatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FavCatsFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRc()

    }

    private fun setUpRc() = with(binding){
        adapter = CatsAdapter(this@FavCatsFragment)
        rcView.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        rcView.adapter = adapter
        viewModel.catsResponse.observe(requireActivity(),{
            adapter.cats = it
        })


    }

    companion object {
        @JvmStatic
        fun newInstance() = FavCatsFragment()
    }

    override fun addToFav() {
        viewModel.addToFav()
    }

    override fun removeFromFav() {
        viewModel.deleteFav()
    }
}