package ir.abzardanesh.shopecommerce.view.adapter.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.reactivex.Observer
import ir.abzardanesh.shopecommerce.ViewModel.LoginViewModel
import ir.abzardanesh.shopecommerce.databinding.ActivityLoginBinding
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.App
import ir.abzardanesh.shopecommerce.repository.Factory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewmodel = ViewModelProvider(this,
            Factory(App()))[LoginViewModel::class.java]


        viewmodel.getLogin(
            binding.edtMobile.text.toString(), binding.edtPass.text.toString()
        )

        binding.btnLogin.setOnClickListener() {


            viewmodel.mutable.observe(this, io.reactivex.Observer {

                if (it.status == "ok") {

                    val intent = Intent(
                        this, ProfileActivity::class.java
                    )
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "موبایل یا رمز عبور اشتباه است !", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            )
        }

        binding.btnReg.setOnClickListener() {

            val intent = Intent(
                applicationContext,
                RegisterActivity::class.java
            )
            startActivity(intent)
        }


    }



}