package com.wednesday.bankingdetails.data

import androidx.room.*
import com.wednesday.bankingdetails.model.Bank

@Dao
interface FavouriteBankDao {
    @Query("SELECT * FROM favourite_banks")
    fun getAll(): List<Bank>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bank: Bank)

    @Delete
    fun delete(bank: Bank)

}