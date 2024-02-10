package data.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app_db.AppDatabase
import data.db.SqlDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single { SqlDriverFactory(context = get<Context>()) }
        single { AppDatabase.invoke(get<SqlDriver>()) }
    }