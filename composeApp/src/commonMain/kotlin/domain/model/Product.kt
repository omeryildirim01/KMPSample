package domain.model

data class Product(
    val id: Int,
    val name: String,
    val image: String,
    val desc: String? = null
)
