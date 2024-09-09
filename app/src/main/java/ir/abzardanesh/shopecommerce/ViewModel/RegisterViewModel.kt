package ir.abzardanesh.shopecommerce.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.abzardanesh.shopecommerce.model.StatusModel
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.RetrofitService

class RegisterViewModel : ViewModel() {

    val mutable = MutableLiveData<StatusModel>()
    private val comp = CompositeDisposable()

    fun setRegister(name:String?,mobile: String?,email:String?,pass:String?){
        ApiRepository.CustomResponse.request(RetrofitService.apiService.getRegister(
            name!!,mobile!!, email!!,pass!!
        ),comp
        ){
           mutable.value = it
        }
    }


    override fun onCleared() {
        comp.clear()
        super.onCleared()
    }
}