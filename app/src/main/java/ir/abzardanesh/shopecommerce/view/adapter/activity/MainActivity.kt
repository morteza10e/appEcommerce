package ir.abzardanesh.shopecommerce.view.adapter.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.abzardanesh.shopecommerce.Utils.ClickItem
import ir.abzardanesh.shopecommerce.ViewModel.LPostViewModel
import ir.abzardanesh.shopecommerce.databinding.ActivityMainBinding
import ir.abzardanesh.shopecommerce.model.PostModel
import ir.abzardanesh.shopecommerce.repository.App
import ir.abzardanesh.shopecommerce.repository.Factory
import ir.abzardanesh.shopecommerce.view.adapter.ProductRecyclerView

class MainActivity : AppCompatActivity(),ClickItem {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)






        val viewmodel = ViewModelProvider(this, Factory(App())).get(LPostViewModel::class.java)
        viewmodel.getList()
        viewmodel.mutable.observe(this, Observer {
            setupRecyclerView(it)
        })

    }

    private fun setupRecyclerView(listProduct:List<PostModel>){
        binding.recyclerviewShop.also {
            it.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            it.adapter = ProductRecyclerView(listProduct,this)
        }


    }

    override fun onClick(id: Int) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("idProduct",id.toString())
        startActivity(intent)
    }
}