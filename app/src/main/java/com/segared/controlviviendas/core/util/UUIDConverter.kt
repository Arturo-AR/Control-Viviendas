package com.segared.controlviviendas.core.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {

    @TypeConverter
    fun stringFromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String): UUID {
        return UUID.fromString(string)
    }
}