package ir.abzardanesh.shopecommerce.repository

import android.content.Context
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.prefs.Preferences


class ApiRepository() {


    object CustomResponse{

        fun <T:Any> request(api: Single<T>, com: CompositeDisposable, call:(T)->Unit){
            com.add(api
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<T>(){
                    override fun onSuccess(t: T) {
                        call.invoke(t)
                    }

                    override fun onError(e: Throwable) {

                    }

                })
            )
        }
    }

    object SharedPreference{
        fun setSharedUser(context:Context,id:String){
            val sharedPreferences = context.getSharedPreferences("user",0)
            val editor = sharedPreferences.edit()
            editor.putString("user_id",id)
            editor.apply()
        }

        fun getSharedUser(context:Context):String{
            val sharedPreferences = context.getSharedPreferences("user",0)
            val userid=sharedPreferences.getString("user_id","")
            return userid!!
        }
    }

}
