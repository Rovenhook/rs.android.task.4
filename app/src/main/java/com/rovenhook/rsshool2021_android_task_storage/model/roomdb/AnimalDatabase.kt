package com.rovenhook.rsshool2021_android_task_storage.model.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rovenhook.rsshool2021_android_task_storage.model.entities.Animal

@Database(entities = arrayOf(Animal::class), version = 1)
abstract class AnimalDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}