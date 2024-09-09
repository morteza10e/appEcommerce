package ir.abzardanesh.shopecommerce.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.abzardanesh.shopecommerce.databinding.ItemOrderBinding
import ir.abzardanesh.shopecommerce.model.OrderModel

class OrderListAdapter(private val orderList:List<OrderModel>)
    :RecyclerView.Adapter<OrderListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemOrderBinding.inflate(LayoutInflater.from(parent.context),
            parent,false))
    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.tvCode.text = orderList[position].code_pardakht
        holder.binding.textvPrice.text = orderList[position].price

        if (orderList[position].status=="1"){
            holder.binding.btnOk.visibility = View.VISIBLE
            holder.binding.btnNo.visibility = View.INVISIBLE
        }else{
            holder.binding.btnOk.visibility = View.INVISIBLE
            holder.binding.btnNo.visibility = View.VISIBLE
        }
    }

    inner class ViewHolder(val binding : ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}