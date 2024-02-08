package data.repository

import data.dto.ProductDto
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
       return httpClient.get("https://fakestoreapi.com/products").body<List<ProductDto>>().toProductModels()
    }
}