package ir.abzardanesh.shopecommerce.view.adapter.activity



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.abzardanesh.shopecommerce.ViewModel.ProfileViewModel
import ir.abzardanesh.shopecommerce.databinding.ActivityProfileBinding
import ir.abzardanesh.shopecommerce.repository.App
import ir.abzardanesh.shopecommerce.repository.Factory
import ir.abzardanesh.shopecommerce.view.adapter.OrderListAdapter

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewmodel = ViewModelProvider(this, Factory(App()))[ProfileViewModel::class.java]

        viewmodel.getUserInfo("1")
        viewmodel.mutable.observe(this, Observer {
            binding.tvName.text = it[0].name
            binding.tvNumber.text = it[0].mobile
            binding.tvEmail.text = it[0].email
        })


        viewmodel.mutableOrder.observe(this, Observer { listOrder ->
            binding.recyclerview.also { rec ->
                rec.layoutManager = LinearLayoutManager(this)
                rec.adapter = OrderListAdapter(listOrder)
            }

        })
    }
}

