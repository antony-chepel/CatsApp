package com.catsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.catsapp.R
import com.catsapp.data.repository.remote.model.CatsResponseItem
import com.catsapp.databinding.CatsItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class CatsAdapter(private val listener: Listener) : RecyclerView.Adapter<CatsAdapter.CatsItemHolder>() {

    private val diffUtilCallback = object : DiffUtil.ItemCallback<CatsResponseItem>(){
        override fun areItemsTheSame(oldItem: CatsResponseItem, newItem: CatsResponseItem): Boolean {
            return  oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CatsResponseItem, newItem: CatsResponseItem): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this,diffUtilCallback)

    var cats : List<CatsResponseItem>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    class CatsItemHolder(private val binding: CatsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setCatsData(item : CatsResponseItem, listener: Listener) = with(binding){

            tvCat.text = item.name

            Picasso.get().load(item.image.url).resize(1280,720)
                .into(imCat,object : Callback{
                    override fun onSuccess() {
                        progressBar.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {

                    }

                })

            imFav.setOnClickListener {
//               if(!item.isFav){
//                   imFav.setImageResource(R.drawable.ic_fav_no)
//                   listener.addToFav()
//               } else {
//                   imFav.setImageResource(R.drawable.ic_fav)
//                   listener.removeFromFav()
//
//               }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsItemHolder {
     val binding = CatsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CatsItemHolder(binding)
    }

    override fun onBindViewHolder(holder: CatsItemHolder, position: Int) {
        holder.setCatsData(cats[position],listener)
    }

    override fun getItemCount() = cats.size
}

interface Listener{
    fun addToFav()
    fun removeFromFav()
}

