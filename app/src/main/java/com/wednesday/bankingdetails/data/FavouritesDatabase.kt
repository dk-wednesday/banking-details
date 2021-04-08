package com.wednesday.bankingdetails.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavouriteBankEntity::class], version = 1)
abstract class FavouritesDatabase : RoomDatabase() {

    abstract fun favouriteBankDao(): FavouriteBankDao

    companion object {
        private var INSTANCE: FavouritesDatabase? = null

        fun getDatabase(context: Context): FavouritesDatabase? {
            if (INSTANCE == null) {
                synchronized(FavouritesDatabase::class)
                {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavouritesDatabase::class.java,
                        "favourite-list.db"
                    ).build()
                }
            }

            return INSTANCE
        }
    }
}