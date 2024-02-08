package domain.mapper

import data.dto.ProductDto
import domain.model.Product

fun ProductDto.toModel() = Product(
    id = this.id,
    name = this.title.orEmpty(),
    image = this.image.orEmpty()
)

fun List<ProductDto>.toProductModels() = map {
    it.toModel()
}