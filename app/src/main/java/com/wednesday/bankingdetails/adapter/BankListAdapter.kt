package com.wednesday.bankingdetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wednesday.bankingdetails.R
import com.wednesday.bankingdetails.model.Bank
import com.wednesday.bankingdetails.utility.Utils
import java.util.*

class BankListAdapter(var bankDataSource: ArrayList<Bank>) :
    RecyclerView.Adapter<BankListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtBankName: TextView = itemView.findViewById(R.id.txtBankName)
        val txtIfsCode: TextView = itemView.findViewById(R.id.txtIfsCode)
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

        val name = "${holder.itemView.resources.getString(R.string.bank_name)}: ${bank.bankName}"
        val ifsc = "${holder.itemView.resources.getString(R.string.ifsc)}: ${bank.ifsCode}"
        holder.txtBankName.text = Utils.capitalizeFirstLetter(name)
        holder.txtIfsCode.text = ifsc.toUpperCase(
            Locale.getDefault()
        )
    }

    fun resetDataSource(bank: List<Bank>) {
        bankDataSource.clear()
        bankDataSource.addAll(bank)
        notifyDataSetChanged()
    }
}