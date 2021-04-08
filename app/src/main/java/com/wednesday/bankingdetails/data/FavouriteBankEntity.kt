package com.wednesday.bankingdetails.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_banks")
data class FavouriteBankEntity(
    @PrimaryKey var ifsc: String,
    @ColumnInfo(name = "bank_name") var bankName: String

)
