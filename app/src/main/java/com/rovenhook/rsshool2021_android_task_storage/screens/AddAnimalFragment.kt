package com.rovenhook.rsshool2021_android_task_storage.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.rovenhook.rsshool2021_android_task_storage.R
import com.rovenhook.rsshool2021_android_task_storage.databinding.FragmentAddAnimalBinding
import com.rovenhook.rsshool2021_android_task_storage.model.entities.Animal
import com.rovenhook.rsshool2021_android_task_storage.viewmodels.AnimalsViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddAnimalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddAnimalFragment : Fragment() {
    private var _binding: FragmentAddAnimalBinding? = null
    private val binding: FragmentAddAnimalBinding get() = _binding!!

    // TODO: Rename and change types of parameters
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
        _binding = FragmentAddAnimalBinding.inflate(inflater, container, false)

        binding.buttonCancel.setOnClickListener {
            getBackToMainScreen()
        }

        binding.buttonConfirm.setOnClickListener {
            val name: String = binding.editTextName.text.toString()
            val age: String = binding.editTextAge.text.toString()
            val breed: String = binding.editTextBreed.text.toString()

            if (name.isNotEmpty() && age.isNotEmpty() && breed.isNotEmpty()) {
                val viewModel: AnimalsViewModel by viewModels()
                val animal = Animal(name, age.toInt(), breed)
                viewModel.addAnimal(animal)
                getBackToMainScreen()
            } else {
                Toast.makeText(activity, "All the field must be filled", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
    
    fun getBackToMainScreen() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentContainerView, AnimalsListFragment())?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddAnimalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddAnimalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}