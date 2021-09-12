package com.rovenhook.rsshool2021_android_task_storage.model.sqlitedb

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.rovenhook.rsshool2021_android_task_storage.utils.ANIMALS_DATABASE_NAME
import com.rovenhook.rsshool2021_android_task_storage.utils.ANIMALS_DATABASE_VERSION
import com.rovenhook.rsshool2021_android_task_storage.utils.CREATE_TABLE_COMMAND
import com.rovenhook.rsshool2021_android_task_storage.utils.DROP_TABLE_COMMAND


class AnimalsDbHelper(application: Application) : SQLiteOpenHelper(application, ANIMALS_DATABASE_NAME, null, ANIMALS_DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_COMMAND)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE_COMMAND)
        onCreate(db)
    }
}
