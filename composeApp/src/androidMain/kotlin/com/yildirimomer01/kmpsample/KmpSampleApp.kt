package com.yildirimomer01.kmpsample

import android.app.Application
import initKoin
import org.koin.dsl.module

class KmpSampleApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin{
            it.modules(
                module {
                    single { this@KmpSampleApp }
                }
            )
        }
    }
}