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
import com.catsapp.databinding.FragmentAllCatsBinding
import com.catsapp.viewmodel.CatsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllCatsFragment : Fragment(),Listener {
    private lateinit var binding : FragmentAllCatsBinding
    private lateinit var adapter : CatsAdapter
    private val viewModel : CatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentAllCatsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRc()

    }

    private fun setUpRc() = with(binding){
        adapter = CatsAdapter(this@AllCatsFragment)
        rcView.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        rcView.adapter = adapter


        viewModel.catsResponse.observe(requireActivity(),{
            adapter.cats = it
        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = AllCatsFragment()
    }

    override fun addToFav() {
        viewModel.addToFav()

    }

    override fun removeFromFav() {
        viewModel.deleteFav()

    }
}