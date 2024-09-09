package ir.abzardanesh.shopecommerce.model

data class AddCartModel(
    val price: List<PriceX>,
    val status: String
)

data class PriceX(
    val price: String
)