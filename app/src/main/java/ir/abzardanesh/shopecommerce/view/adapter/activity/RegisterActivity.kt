package ir.abzardanesh.shopecommerce.view.adapter.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.abzardanesh.shopecommerce.ViewModel.RegisterViewModel
import ir.abzardanesh.shopecommerce.databinding.ActivityRegisterBinding
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.App
import ir.abzardanesh.shopecommerce.repository.Factory

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewmodel = ViewModelProvider(this, Factory(App()))[RegisterViewModel::class.java]

        binding.btnRegister.setOnClickListener() {
            viewmodel.setRegister(
                binding.edtName.text.toString(),
                binding.edtMobile.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPass.text.toString()
            )

            viewmodel.mutable.observe(this, Observer {
                if (it.status == "ok") {
                    val intent = Intent(
                        applicationContext,
                        ProfileActivity::class.java
                    )
                    startActivity(intent)


                } else {
                    Toast.makeText(this, "ثبت نام موفقیت آمیز نبود", Toast.LENGTH_SHORT).show()
                }
            })

        }

        binding.btnLog.setOnClickListener() {


            val intent = Intent(
                applicationContext,
                LoginActivity::class.java
            )
            startActivity(intent)

        }
    }

}