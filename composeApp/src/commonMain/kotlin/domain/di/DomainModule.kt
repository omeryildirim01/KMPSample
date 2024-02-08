package domain.di

import domain.usecase.GetProductListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetProductListUseCase() }
}