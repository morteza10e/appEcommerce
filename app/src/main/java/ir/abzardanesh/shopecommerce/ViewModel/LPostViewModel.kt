package ir.abzardanesh.shopecommerce.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.abzardanesh.shopecommerce.model.PostModel
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.RetrofitService

class LPostViewModel : ViewModel() {
    val mutable = MutableLiveData<ArrayList<PostModel>>()
    private val comp = CompositeDisposable()



    fun getList(){
        ApiRepository.CustomResponse.request(RetrofitService.apiService.getList(),comp)
        {
            mutable.value = it
        }
    }

}