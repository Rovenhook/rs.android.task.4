package com.rovenhook.rsshool2021_android_task_storage.utils

const val ANIMALS_DATABASE_NAME = "animals_database.db"
const val ANIMALS_DATABASE_VERSION = 1
const val ANIMALS_TABLE_NAME = "animals_table"
const val COLUMN_NAME = "name"
const val COLUMN_AGE = "age"
const val COLUMN_BREED = "breed"
const val COLUMN_ID = "id"

const val QUERY_SELECT_ALL_ANIMALS = "SELECT * FROM $ANIMALS_TABLE_NAME"

const val CREATE_TABLE_COMMAND = "CREATE TABLE IF NOT EXISTS $ANIMALS_TABLE_NAME " +
        "($COLUMN_NAME TEXT, $COLUMN_AGE INTEGER, $COLUMN_BREED TEXT" +
        ", $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT)"

const val DROP_TABLE_COMMAND = "DROP TABLE IF EXISTS $ANIMALS_TABLE_NAME"

const val SWITCHED_TO_ROOM = 1
const val SWITCHED_TO_SQL = 2



