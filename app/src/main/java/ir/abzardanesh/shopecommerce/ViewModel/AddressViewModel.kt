package ir.abzardanesh.shopecommerce.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.abzardanesh.shopecommerce.model.AddressModel
import ir.abzardanesh.shopecommerce.model.PostDetails
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.RetrofitService

class AddressViewModel : ViewModel() {

    val mutable = MutableLiveData<List<AddressModel>>()
    private val comp = CompositeDisposable()

    fun getAddress(id: String) {
        ApiRepository.CustomResponse.request(
            RetrofitService.apiService.getAddress(id), comp
        ) {
            mutable.value = it
        }
    }
}