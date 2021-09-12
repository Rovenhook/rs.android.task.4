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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AnimalsListFragment : Fragment() {
    private var _binding: FragmentAnimalsListBinding? = null
    private val binding: FragmentAnimalsListBinding get() = _binding!!
    private val viewModel: AnimalsViewModel by viewModels()

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainerView, AddAnimalFragment())?.commit()
        }

        return binding.root
    }

    fun getOnAnimalClickListener() = object : OnAnimalClickListener {
        override fun onDeleteClicked(animal: Animal) {
            viewModel.deleteAnimal(animal)
        }

        override fun onEditClicked(animal: Animal) {
            TODO("Not yet implemented")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnimalsListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}