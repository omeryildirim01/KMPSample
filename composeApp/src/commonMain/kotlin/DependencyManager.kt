import data.di.dataModule
import domain.di.domainModule
import org.koin.core.context.startKoin
import presentation.di.presentationModule

fun initKoinModule() {
    startKoin {
        modules(dataModule, domainModule, presentationModule)
    }
}