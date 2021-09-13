package com.rovenhook.rsshool2021_android_task_storage.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rovenhook.rsshool2021_android_task_storage.model.repositories.AbstractRepository
import com.rovenhook.rsshool2021_android_task_storage.model.entities.Animal
import com.rovenhook.rsshool2021_android_task_storage.model.repositories.RepositoryRoom
import com.rovenhook.rsshool2021_android_task_storage.model.repositories.RepositorySQLite
import com.rovenhook.rsshool2021_android_task_storage.utils.SWITCHED_TO_ROOM
import kotlinx.coroutines.launch

class AnimalsViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: AbstractRepository = RepositoryRoom(getApplication())//RepositorySQLite(getApplication())
    private var repositoryMode: Int = SWITCHED_TO_ROOM

    fun changeRepositoryType(switchTo: Int) {
        if (switchTo != repositoryMode) {
            repository = if (switchTo == SWITCHED_TO_ROOM) {
                RepositoryRoom(getApplication())
            } else {
                RepositorySQLite(getApplication())
            }
        }
    }

    fun getAllAnimals(): LiveData<List<Animal>> {
        lateinit var animalsLiveData: LiveData<List<Animal>>
        viewModelScope.launch {
            animalsLiveData = repository.getAllAnimals()
        }

        return animalsLiveData
    }

    fun addAnimal(animal: Animal) {
        viewModelScope.launch {
            repository.addAnimal(animal)
        }
    }

    fun deleteAnimal(animal: Animal) {
        viewModelScope.launch {
            repository.deleteAnimal(animal)
        }
    }

    fun updateAnimal(animal: Animal) {
        viewModelScope.launch {
            repository.updateAnimal(animal)
        }
    }
}