package ir.abzardanesh.shopecommerce.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.abzardanesh.shopecommerce.model.CartModel
import ir.abzardanesh.shopecommerce.model.PriceModel
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.RetrofitService

class CartViewModel: ViewModel() {
    val mutable = MutableLiveData<List<PriceModel>>()
    val mutableCart = MutableLiveData<ArrayList<CartModel>>()
    private val comp = CompositeDisposable()

    fun getCartPrice(user: String) {
        ApiRepository.CustomResponse.request(
            RetrofitService.apiService.getPrice(user), comp
        ) {
            mutable.value = it
        }

        ApiRepository.CustomResponse.request(
            RetrofitService.apiService.getCart(user), comp
        ) {
            mutableCart.value = it
        }



    }
}