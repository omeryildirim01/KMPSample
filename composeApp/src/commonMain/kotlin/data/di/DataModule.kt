package data.di

import data.repository.ProductRepositoryImpl
import domain.repository.ProductRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
    }

    factory<ProductRepository> { ProductRepositoryImpl(get<HttpClient>()) }
}