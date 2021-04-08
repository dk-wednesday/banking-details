package com.wednesday.bankingdetails.model

import android.content.Context

class BankFactory {

    companion object {
        fun getMockBanks(context: Context): ArrayList<Bank> {
            val bankList = ArrayList<Bank>()

            var bank = Bank("HDFC Bank", "HDFC0000181", false)
            bankList.add(bank)
            bank = Bank("ICICI Bank", "ICIC0000379", false)
            bankList.add(bank)
            bank = Bank("Yes Bank", "YESB0000100", false)
            bankList.add(bank)
            bank = Bank("Bank of Maharashtra", "MAHB0000937", false)
            bankList.add(bank)
            bank = Bank("IDBI Bank", "IBKL0002051", false)
            bankList.add(bank)
            bank = Bank("Bank of Baroda", "BARB0AHMEDN", false)
            bankList.add(bank)
            bank = Bank("Axis Bank", "UTIB0000215", false)
            bankList.add(bank)
            bank = Bank("Bandhan Bank", "BDBL0001940", false)
            bankList.add(bank)
            bank = Bank("Federal Bank", "FDRL0001588", false)
            bankList.add(bank)
            bank = Bank("Kotak Mahindra Bank", "KKBK0002035", false)
            bankList.add(bank)
            bank = Bank("State Bank of India", "SBIN0021748", false)
            bankList.add(bank)

            return bankList
        }
    }
}
