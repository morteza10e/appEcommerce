package ir.abzardanesh.shopecommerce.view.adapter.activity

//import ir.abzardanesh.shopecommerce.view.adapter.SliderImage
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.abzardanesh.shopecommerce.ViewModel.DetailsViewModel
import ir.abzardanesh.shopecommerce.databinding.ActivityDetailsBinding
import ir.abzardanesh.shopecommerce.repository.App
import ir.abzardanesh.shopecommerce.repository.Factory

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)




        var viewmodel = ViewModelProvider(this, Factory(App())).get(DetailsViewModel::class.java)


        val intent = intent

        viewmodel.getDetails(intent.getStringExtra("idProduct").toString())
        viewmodel.mutable.observe(this, Observer {

            binding.tvTitle.text = it.post[0].title
            binding.tvDes.text = it.post[0].des
            binding.tvDate.text = it.post[0].date
            binding.tvView.text = it.post[0].view + " بازید"

//            binding.slider.setSliderAdapter(SliderImage(it.slider))

//            binding.slider.setImageDrawable(it.slider[0].image)




        })



    }






}

