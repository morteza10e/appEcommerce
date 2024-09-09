package ir.abzardanesh.shopecommerce.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.reactivex.disposables.CompositeDisposable
import ir.abzardanesh.shopecommerce.Utils.ChangeItems
import ir.abzardanesh.shopecommerce.databinding.ItemsCartBinding
import ir.abzardanesh.shopecommerce.model.CartModel
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.RetrofitService

class CartListAdapter(
    val context: Context,
    private val listCart: ArrayList<CartModel>,
    val change: ChangeItems,
    private val user: String
) : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: ItemsCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsCartBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = listCart.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text = listCart[position].title
        holder.binding.tvPrice.text = listCart[position].price + " تومان "
        holder.binding.tvCount.text = listCart[position].count +  " تعداد "

        Glide.with(context).load(
            listCart[position].imageurl
        ).into(holder.binding.imagePost)

        holder.binding.imageMosbat.setOnClickListener() {
            val comp = CompositeDisposable()
            ApiRepository.CustomResponse.request(
                RetrofitService.apiService.addCart(
                    listCart[position].idproduct, "1", user, "add"
                ), comp
            ) {
                if (it.status == "ok") {
                    holder.binding.tvPrice.text = it.price[0].price + " تومان "
                    change.getChange()
                }


            }
        }
        holder.binding.imageMines.setOnClickListener() {
            val comp = CompositeDisposable()
            ApiRepository.CustomResponse.request(
                RetrofitService.apiService.addCart(
                    listCart[position].idproduct, "1", user, "m"
                ), comp
            ) {
                if (it.status == "ok") {
                    holder.binding.tvPrice.text = it.price[0].price + " تومان "
                    change.getChange()
                }
            }

        }
    }
}

