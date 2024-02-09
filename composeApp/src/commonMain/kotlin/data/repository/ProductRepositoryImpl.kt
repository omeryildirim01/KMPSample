package data.repository

import data.dto.ProductDto
import domain.mapper.toModel
import domain.mapper.toProductModels
import domain.model.Product
import domain.repository.ProductRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductRepositoryImpl(
    private val httpClient: HttpClient
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
       return httpClient.get(STORE_API).body<List<ProductDto>>().toProductModels()
    }

    override suspend fun getProduct(productId: Int): Product {
        return httpClient.get("$STORE_API/${productId}").body<ProductDto>().toModel()
    }

    companion object {
        private const val STORE_API = "https://fakestoreapi.com/products"
    }
}