package ir.abzardanesh.shopecommerce.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.abzardanesh.shopecommerce.model.OrderModel
import ir.abzardanesh.shopecommerce.model.ProfileModel
import ir.abzardanesh.shopecommerce.model.StatusModel
import ir.abzardanesh.shopecommerce.repository.ApiRepository
import ir.abzardanesh.shopecommerce.repository.RetrofitService

class ProfileViewModel:ViewModel() {

    val mutable = MutableLiveData<List<ProfileModel>>()
    val mutableOrder = MutableLiveData<List<OrderModel>>()
    private val comp = CompositeDisposable()


    fun getUserInfo(userId:String){
        ApiRepository.CustomResponse.request(
            RetrofitService.apiService.userInfoProfile(userId), comp
        ) {
            mutable.value = it
        }


        ApiRepository.CustomResponse.request(
            RetrofitService.apiService.listOrder(userId),comp
        ){
            mutableOrder.value = it
        }

    }




}