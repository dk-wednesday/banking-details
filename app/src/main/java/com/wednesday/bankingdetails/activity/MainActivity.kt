package com.wednesday.bankingdetails.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wednesday.bankingdetails.R
import com.wednesday.bankingdetails.adapter.BankListAdapter
import com.wednesday.bankingdetails.model.Bank
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bankListAdapter: BankListAdapter
        val bankList: ArrayList<Bank> = Bank.createMockBanks()

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
            )
        )

        bankListAdapter = BankListAdapter(bankList)
        recyclerView.adapter = bankListAdapter

    }
}
