package com.wednesday.bankingdetails.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wednesday.bankingdetails.model.Bank

@Database(entities = [Bank::class], version = 1)
abstract class FavouritesDatabase : RoomDatabase() {

    abstract fun favouriteBankDao(): FavouriteBankDao

    companion object {
        private lateinit var INSTANCE: FavouritesDatabase

        fun getDatabase(context: Context): FavouritesDatabase {
            synchronized(FavouritesDatabase::class)
            {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    FavouritesDatabase::class.java,
                    "favourite-list.db"
                ).build()
            }

            return INSTANCE
        }
    }
}
