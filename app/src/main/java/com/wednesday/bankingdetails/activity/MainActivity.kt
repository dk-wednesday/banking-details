package com.wednesday.bankingdetails.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wednesday.bankingdetails.R
import com.wednesday.bankingdetails.adapter.BankListAdapter
import com.wednesday.bankingdetails.data.FavouritesDatabase
import com.wednesday.bankingdetails.listener.BankFavouriteListener
import com.wednesday.bankingdetails.model.Bank
import com.wednesday.bankingdetails.model.BankFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), BankFavouriteListener {

    private val bankList: ArrayList<Bank> by lazy {
        BankFactory.getMockBanks()
    }
    private val bankListAdapter: BankListAdapter by lazy {
        BankListAdapter(bankList)
    }
    private val bankDatabase: FavouritesDatabase by lazy {
        FavouritesDatabase.getDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = bankListAdapter

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                LinearLayoutManager.VERTICAL
            )
        )

        bindFavouriteBanks()
    }

    private fun bindFavouriteBanks() {
        GlobalScope.launch {
            val data = bankDatabase.favouriteBankDao().getAll()

            data.forEach {
                bankList.find { bank -> bank.ifsc == it.ifsc }?.let { it.isFavourite = true }
            }

            withContext(Dispatchers.Main) {
                bankListAdapter.refreshData()
            }
        }
    }

    override fun favouriteBank(bank: Bank) {
        GlobalScope.launch {
            bankDatabase.favouriteBankDao().insert(bank)
            bindFavouriteBanks()

        }
    }

    override fun unFavouriteBank(bank: Bank) {
        GlobalScope.launch {
            bankDatabase.favouriteBankDao().delete(bank)
            bindFavouriteBanks()
        }

    }
}
