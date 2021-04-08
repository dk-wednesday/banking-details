package com.wednesday.bankingdetails.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.wednesday.bankingdetails.R
import com.wednesday.bankingdetails.adapter.BankListAdapter
import com.wednesday.bankingdetails.data.FavouritesDatabase
import com.wednesday.bankingdetails.model.Bank
import com.wednesday.bankingdetails.model.BankFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext, FavouritesDatabase::class.java, "favourite-list.db").build()

        val bankListAdapter: BankListAdapter
        val bankList: ArrayList<Bank> = BankFactory.getMockBanks()

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
