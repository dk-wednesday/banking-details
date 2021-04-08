package com.wednesday.bankingdetails.model

class BankFactory {

    companion object {
        fun getMockBanks(): ArrayList<Bank> {
            val bankList = ArrayList<Bank>()

            var bank = Bank("HDFC0000181", "HDFC Bank", false)
            bankList.add(bank)
            bank = Bank("ICIC0000379", "ICICI Bank", false)
            bankList.add(bank)
            bank = Bank("YESB0000100", "Yes Bank", false)
            bankList.add(bank)
            bank = Bank("MAHB0000937", "Bank of Maharashtra", false)
            bankList.add(bank)
            bank = Bank("IBKL0002051", "IDBI Bank", false)
            bankList.add(bank)
            bank = Bank("BARB0AHMEDN", "Bank of Baroda", false)
            bankList.add(bank)
            bank = Bank("UTIB0000215", "Axis Bank", false)
            bankList.add(bank)
            bank = Bank("BDBL0001940", "Bandhan Bank", false)
            bankList.add(bank)
            bank = Bank("FDRL0001588", "Federal Bank", false)
            bankList.add(bank)
            bank = Bank("KKBK0002035", "Kotak Mahindra Bank", false)
            bankList.add(bank)
            bank = Bank("SBIN0021748", "State Bank of India", false)
            bankList.add(bank)

            return bankList
        }
    }
}
