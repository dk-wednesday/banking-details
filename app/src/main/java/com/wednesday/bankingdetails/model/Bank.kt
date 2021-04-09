package com.wednesday.bankingdetails.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_banks")
data class Bank(
    @PrimaryKey var ifsc: String,
    @ColumnInfo(name = "bank_name") var bankName: String,
    @ColumnInfo(name = "is_favourite") var isFavourite: Boolean
)