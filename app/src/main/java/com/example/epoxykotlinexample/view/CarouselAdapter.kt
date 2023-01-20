package com.example.epoxykotlinexample.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.epoxykotlinexample.databinding.CarouselItemBinding
import com.example.epoxykotlinexample.view.CarouselAdapter.*

class CarouselAdapter: ListAdapter<Int, CarouselHolder>(DiffUtilCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselHolder {
        return CarouselHolder(
            CarouselItemBinding.inflate( LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: CarouselHolder, position: Int) {
        holder.bind(getItem(position))
    }

   inner class CarouselHolder(private val binding: CarouselItemBinding):RecyclerView.ViewHolder(binding.root) {
       fun bind(image: Int?) {
            image?.let {
                binding.imageCarousel.setImageResource(image)
            }
       }
   }
}
private object DiffUtilCallback : DiffUtil.ItemCallback<Int>(){
    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean =
        oldItem == newItem


    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean =
        oldItem == newItem
}