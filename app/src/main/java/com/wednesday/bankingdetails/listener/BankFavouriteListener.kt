package com.wednesday.bankingdetails.listener

import com.wednesday.bankingdetails.model.Bank

interface BankFavouriteListener {

    fun favouriteBank(bank: Bank)

    fun unFavouriteBank(bank: Bank)

}