package com.wednesday.bankingdetails.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_banks")
data class FavouriteBankEntity(
    @PrimaryKey(autoGenerate = true)
    var fav_bank_id: Int,

    @ColumnInfo(name = "bank_name") var bankName: String,
    @ColumnInfo(name = "ifs_code") var ifsc: String

)
