package com.wednesday.bankingdetails.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wednesday.bankingdetails.R
import com.wednesday.bankingdetails.adapter.BankListAdapter
import com.wednesday.bankingdetails.model.Bank

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var bankListAdapter: BankListAdapter
    private var bankList: ArrayList<Bank> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBanks()

        recyclerView = findViewById(R.id.recyclerView)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.addItemDecoration(DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
        ))

        bankListAdapter = BankListAdapter(this, bankList)
        recyclerView.adapter = bankListAdapter

    }

    private fun addBanks() {
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
    }
}
