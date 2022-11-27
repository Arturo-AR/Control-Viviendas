package com.segared.controlviviendas.core.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "user_data")
data class UserData(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "user") val user: String,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "user_lastname") val userLastname: String,
    @ColumnInfo(name = "user_rol") val userRol: Int,
)
