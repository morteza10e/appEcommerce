package ir.abzardanesh.shopecommerce.model

data class OrderModel(
    val id: String,
    val idaddress: String,
    val iduser: String,
    val price: String,
    val status: String,
    val code_pardakht:String
)