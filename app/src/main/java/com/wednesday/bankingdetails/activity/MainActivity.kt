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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bankListAdapter: BankListAdapter
        val bankList: ArrayList<Bank> = BankFactory.getMockBanks(this)

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
            )
        )


        val bankDatabase = FavouritesDatabase.getDatabase(this)

        GlobalScope.launch {
            val data = bankDatabase?.favouriteBankDao()?.getAll()

            data?.forEach {
                bankList.find { bank -> bank.ifsCode == it.ifsc }!!.isFavourite = true
            }

            withContext(Dispatchers.Main){
                bankListAdapter = BankListAdapter(bankList)
                recyclerView.adapter = bankListAdapter

            }
        }

    }
}
