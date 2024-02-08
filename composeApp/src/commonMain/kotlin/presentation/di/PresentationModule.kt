package presentation.di

import org.koin.dsl.module
import presentation.productlist.ProductListViewModel


val presentationModule = module {

    factory { ProductListViewModel(get()) }
}