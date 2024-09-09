package ir.abzardanesh.shopecommerce.view.adapter.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.abzardanesh.shopecommerce.Utils.ChangeItems
import ir.abzardanesh.shopecommerce.ViewModel.CartViewModel
import ir.abzardanesh.shopecommerce.databinding.ActivityCartBinding
import ir.abzardanesh.shopecommerce.repository.App
import ir.abzardanesh.shopecommerce.repository.Factory
import ir.abzardanesh.shopecommerce.view.adapter.CartListAdapter

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewmodel = ViewModelProvider(
            this,
            Factory(App())
        )[CartViewModel::class.java]


        getPrice(viewmodel,"1")


        viewmodel.mutableCart.observe(this, Observer
        {itList->
            binding.recyclerviewShop.also {
                val adaprer = CartListAdapter(this,itList,
                    object :ChangeItems{
                        override fun getChange() {
                            getPrice(viewmodel,"1")
                        }

                    },"1")

                it.adapter = adaprer
                it.layoutManager = LinearLayoutManager(this)



            }


        })
    }

    @SuppressLint("SetTextI18n")
    fun getPrice(viewmodel: CartViewModel, user: String) {
        viewmodel.getCartPrice(user)
        viewmodel.mutable.observe(this, Observer {
            binding.tvPriceAll.text = it[0].price + " تومان  "
        })
    }


}
