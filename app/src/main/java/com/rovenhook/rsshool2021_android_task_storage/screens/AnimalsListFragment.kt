package com.rovenhook.rsshool2021_android_task_storage.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rovenhook.rsshool2021_android_task_storage.R
import com.rovenhook.rsshool2021_android_task_storage.adapters.AnimalsAdapter
import com.rovenhook.rsshool2021_android_task_storage.databinding.FragmentAnimalsListBinding
import com.rovenhook.rsshool2021_android_task_storage.model.entities.Animal
import com.rovenhook.rsshool2021_android_task_storage.viewmodels.AnimalsViewModel
import com.rovenhook.rsshool2021_android_task_storage.listeners.OnAnimalClickListener



class AnimalsListFragment : Fragment() {
    private var _binding: FragmentAnimalsListBinding? = null
    private val binding: FragmentAnimalsListBinding get() = _binding!!
    private val viewModel: AnimalsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalsListBinding.inflate(inflater, container, false)

        val adapter = AnimalsAdapter(getOnAnimalClickListener())
        binding.recyclerViewAnimals.adapter = adapter
        binding.recyclerViewAnimals.layoutManager = LinearLayoutManager(activity)

        viewModel.getAllAnimals().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        binding.floatingActionButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, AddAnimalFragment()).commit()
        }

        return binding.root
    }

    fun getOnAnimalClickListener() = object : OnAnimalClickListener {
        override fun onDeleteClicked(animal: Animal) {
            viewModel.deleteAnimal(animal)
        }

        override fun onEditClicked(animal: Animal) {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, EditAnimalFragment(animal)).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}