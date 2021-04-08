package com.wednesday.bankingdetails.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavouriteBankEntity::class], version = 1)
abstract class FavouritesDatabase : RoomDatabase() {

    abstract fun favouriteBankDao() : FavouriteBankDao
}