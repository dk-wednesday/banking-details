package com.wednesday.bankingdetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wednesday.bankingdetails.R
import com.wednesday.bankingdetails.data.FavouriteBankEntity
import com.wednesday.bankingdetails.data.FavouritesDatabase
import com.wednesday.bankingdetails.extensions.capitalizeFirstLetter
import com.wednesday.bankingdetails.model.Bank
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_item_bank.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class BankListAdapter(var bankDataSource: ArrayList<Bank>) :
    RecyclerView.Adapter<BankListAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(bank: Bank) {
            val name =
                "${itemView.resources.getString(R.string.bank_name)}: ${bank.bankName}"
            val ifsc = "${itemView.resources.getString(R.string.ifsc)}: ${bank.ifsCode}"
            itemView.txtBankName.text = name.capitalizeFirstLetter()
            itemView.txtIfsCode.text = ifsc.toUpperCase(
                Locale.getDefault()
            )
            if (bank.isFavourite) {
                itemView.imgStar.visibility = View.VISIBLE
            } else {
                itemView.imgStar.visibility = View.GONE
            }


            val bankDatabase = FavouritesDatabase.getDatabase(itemView.context)

            itemView.setOnClickListener {
                bank.isFavourite = !bank.isFavourite
                if (bank.isFavourite) {
                    itemView.imgStar.visibility = View.VISIBLE

                    GlobalScope.launch {
                        val favouriteBankEntity = FavouriteBankEntity(bank.ifsCode, bank.bankName)
                        bankDatabase?.favouriteBankDao()?.insert(favouriteBankEntity)
                    }

                } else {
                    itemView.imgStar.visibility = View.GONE

                    GlobalScope.launch {
                        val favouriteBankEntity = FavouriteBankEntity(bank.ifsCode, bank.bankName)
                        bankDatabase?.favouriteBankDao()?.delete(favouriteBankEntity)
                    }

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_item_bank, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (bankDataSource.isNotEmpty()) bankDataSource.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bank = bankDataSource[position]
        holder.bind(bank)
    }

    fun resetDataSource(bank: List<Bank>) {
        bankDataSource.clear()
        bankDataSource.addAll(bank)
        notifyDataSetChanged()
    }
}