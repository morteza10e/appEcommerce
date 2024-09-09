package ir.abzardanesh.shopecommerce.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.abzardanesh.shopecommerce.model.PostDetails
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.RetrofitService

class DetailsViewModel : ViewModel() {

    val mutable = MutableLiveData<PostDetails>()
    private val comp = CompositeDisposable()

    fun getDetails(id:String){
        ApiRepository.CustomResponse.request(
            RetrofitService.apiService.getDetails(id),comp
        ){
            mutable.value =it


        }
    }

}