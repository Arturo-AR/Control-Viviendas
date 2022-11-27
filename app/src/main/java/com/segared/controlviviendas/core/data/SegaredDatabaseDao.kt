package com.segared.controlviviendas.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.segared.controlviviendas.core.data.entities.UserData
import kotlinx.coroutines.flow.Flow

@Dao
interface SegaredDatabaseDao {

    @Query("SELECT * FROM user_data")
    fun getUserData(): Flow<UserData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserData(userData: UserData)

    @Query("DELETE FROM user_data")
    suspend fun deleteUserData()
}