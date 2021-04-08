package com.wednesday.bankingdetails.model

class BankFactory {

    companion object {
        fun getMockBanks(): ArrayList<Bank> {
            val bankList = ArrayList<Bank>()

            var bank = Bank("HDFC Bank", "HDFC0000181")
            bankList.add(bank)
            bank = Bank("ICICI Bank", "ICIC0000379")
            bankList.add(bank)
            bank = Bank("Yes Bank", "YESB0000100")
            bankList.add(bank)
            bank = Bank("Bank of Maharashtra", "MAHB0000937")
            bankList.add(bank)
            bank = Bank("IDBI Bank", "IBKL0002051")
            bankList.add(bank)
            bank = Bank("Bank of Baroda", "BARB0AHMEDN")
            bankList.add(bank)
            bank = Bank("Axis Bank", "UTIB0000215")
            bankList.add(bank)
            bank = Bank("Bandhan Bank", "BDBL0001940")
            bankList.add(bank)
            bank = Bank("Federal Bank", "FDRL0001588")
            bankList.add(bank)
            bank = Bank("Kotak Mahindra Bank", "KKBK0002035")
            bankList.add(bank)
            bank = Bank("State Bank of India", "SBIN0021748")
            bankList.add(bank)

            return bankList
        }
    }
}