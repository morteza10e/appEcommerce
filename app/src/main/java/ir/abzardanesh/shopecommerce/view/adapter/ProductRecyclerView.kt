package ir.abzardanesh.shopecommerce.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.abzardanesh.shopecommerce.Utils.ClickItem
import ir.abzardanesh.shopecommerce.databinding.ItemProductBinding
import ir.abzardanesh.shopecommerce.model.PostModel

class ProductRecyclerView(private val postModel: List<PostModel>,val clickItem: ClickItem) :
    RecyclerView.Adapter<ProductRecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = postModel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text = postModel[position].title
        holder.binding.tvDate.text = postModel[position].price
        holder.binding.tvDate.text = postModel[position].date

        Glide.with(holder.itemView)
            .load(postModel[position].imageurl)
            .into(holder.binding.imgProduct)

        holder.binding.root.setOnClickListener(){
            clickItem.onClick(position)

        }


    }

    inner class ViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }




}