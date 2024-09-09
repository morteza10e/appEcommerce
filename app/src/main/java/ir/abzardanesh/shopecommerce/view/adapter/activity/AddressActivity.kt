package ir.abzardanesh.shopecommerce.view.adapter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.abzardanesh.shopecommerce.R
import ir.abzardanesh.shopecommerce.ViewModel.AddressViewModel
import ir.abzardanesh.shopecommerce.ViewModel.LoginViewModel
import ir.abzardanesh.shopecommerce.databinding.ActivityAddressBinding
import ir.abzardanesh.shopecommerce.databinding.ActivityCartBinding
import ir.abzardanesh.shopecommerce.repository.App
import ir.abzardanesh.shopecommerce.repository.Factory

class AddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewmodel = ViewModelProvider(this,
            Factory(App())
        )[AddressViewModel::class.java]

        viewmodel.getAddress("1")
        viewmodel.mutable.observe(this, Observer {
            binding.tvCity.text = it[0].city
            binding.tvAddress.text = it[0].address
            binding.tvTell.text = it[0].tell
        })
    }
}