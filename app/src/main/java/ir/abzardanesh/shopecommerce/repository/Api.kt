package ir.abzardanesh.shopecommerce.repository

import io.reactivex.Single
import ir.abzardanesh.shopecommerce.model.AddCartModel
import ir.abzardanesh.shopecommerce.model.AddressModel
import ir.abzardanesh.shopecommerce.model.CartModel
import ir.abzardanesh.shopecommerce.model.DeleteStatusModel
import ir.abzardanesh.shopecommerce.model.OrderModel
import ir.abzardanesh.shopecommerce.model.PostDetails
import ir.abzardanesh.shopecommerce.model.PostModel
import ir.abzardanesh.shopecommerce.model.PriceModel
import ir.abzardanesh.shopecommerce.model.ProfileModel
import ir.abzardanesh.shopecommerce.model.StatusModel
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @GET("index.php")
    fun getList(): Single<ArrayList<PostModel>>


    @POST("postdetails.php")
    fun getDetails(
        @Query("id") id: String
    ): Single<PostDetails>


    @POST("login.php")
    fun getLogin(@Query("mobile") mobile: String, @Query("pass") pass: String):
            Single<StatusModel>


    @POST("reg.php")
    fun getRegister(
        @Query("name") name: String, @Query("mobile") mobile: String,
        @Query("email") email: String, @Query("pass") pass: String
    ): Single<StatusModel>


    @GET("user_info.php")
    fun userInfoProfile(@Query("user_id") userId: String): Single<List<ProfileModel>>


    @GET("list_order.php")
    fun listOrder(@Query("user") user: String): Single<List<OrderModel>>


    @GET("get_price.php")
    fun getPrice(@Query("user") user: String): Single<List<PriceModel>>


    @GET("Get_record_cart.php")
    fun getCart(@Query("user")id:String):Single<ArrayList<CartModel>>


    @GET("Addcart.php")
    fun addCart(@Query("product")idproduct:String,@Query("count")count:String
                ,@Query("user")user:String,@Query("check")check:String)
    :Single<AddCartModel>


    @GET("get_Address.php")
    fun getAddress(@Query("userid")id:String):Single<List<AddressModel>>


    @GET("del_cart.php")
    fun delCart(@Query("idcart")id:String):Single<DeleteStatusModel>
}


