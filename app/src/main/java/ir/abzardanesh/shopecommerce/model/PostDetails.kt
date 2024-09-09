package ir.abzardanesh.shopecommerce.model

data class PostDetails(
    val post: ArrayList<Post>,
    val slider: ArrayList<Slider>
)

data class Post(
    val date: String,
    val des: String,
    val id: String,
    val imageurl: String,
    val price: String,
    val title: String,
    val view: String
)

data class Slider(
    val image: String
)