package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addAWish(wishEntity: Wish)

    //loads all wishes from wish table
    @Query("SELECT * FROM 'wish-table' ")
    abstract fun getAllWishes(): Flow<List<Wish>>

}