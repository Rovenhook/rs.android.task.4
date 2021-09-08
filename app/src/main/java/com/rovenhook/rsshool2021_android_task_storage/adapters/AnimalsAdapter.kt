package com.rovenhook.rsshool2021_android_task_storage.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rovenhook.rsshool2021_android_task_storage.databinding.AnimalItemBinding
import com.rovenhook.rsshool2021_android_task_storage.model.Animal


class AnimalsAdapter : RecyclerView.Adapter<AnimalsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsViewHolder {
        val binding = AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AnimalsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    companion object {
        private val itemComparator = object : DiffUtil.ItemCallback<Animal>() {
            override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
                return oldItem.name == newItem.name &&
                        oldItem.age == newItem.age &&
                        oldItem.breed == newItem.breed
            }

            override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
                TODO("Not yet implemented")
            }

        }
    }
}