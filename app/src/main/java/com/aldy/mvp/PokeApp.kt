package com.aldy.mvp

import android.app.Application
import com.facebook.stetho.Stetho
import com.orhanobut.hawk.Hawk

class PokeApp : Application() {
    private var instance: PokeApp? = null

    fun getInstance(): PokeApp? {
        return instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Stetho.initializeWithDefaults(this)
        Hawk.init(this).build()
    }
}