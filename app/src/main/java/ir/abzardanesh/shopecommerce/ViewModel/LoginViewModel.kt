package ir.abzardanesh.shopecommerce.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.abzardanesh.shopecommerce.model.StatusModel
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.RetrofitService

class LoginViewModel() : ViewModel() {

    val mutable = MutableLiveData<StatusModel>()
    private val comp = CompositeDisposable()

    fun getLogin(mobile: String?,pass:String?) {
        ApiRepository.CustomResponse.request(
            RetrofitService.apiService.getLogin(
                mobile!!, pass!!
            ), comp
        )
        {
            mutable.value = it
        }

    }
    override fun onCleared() {
        comp.clear()
        super.onCleared()
    }
}