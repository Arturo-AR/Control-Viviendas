package com.segared.controlviviendas.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.segared.controlviviendas.core.data.entities.UserData
import com.segared.controlviviendas.core.util.UUIDConverter

@Database(
    entities = [
        UserData::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(UUIDConverter::class)
abstract class SegaredDatabase : RoomDatabase() {
    abstract fun segaredDao(): SegaredDatabaseDao
}