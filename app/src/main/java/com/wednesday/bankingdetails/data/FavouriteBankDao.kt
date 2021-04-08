package com.wednesday.bankingdetails.data

import androidx.room.*

@Dao
interface FavouriteBankDao {
    @Query("SELECT * FROM favourite_banks")
    fun getAll(): List<FavouriteBankEntity>

    @Insert
    fun insert(favouriteBankEntity: FavouriteBankEntity)

    @Delete
    fun delete(favouriteBankEntity: FavouriteBankEntity)

}