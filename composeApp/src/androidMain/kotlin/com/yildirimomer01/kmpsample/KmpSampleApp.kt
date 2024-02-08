package com.yildirimomer01.kmpsample

import android.app.Application
import initKoinModule

class KmpSampleApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinModule()
    }
}