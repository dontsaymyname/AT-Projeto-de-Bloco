package com.pinheiro.michael.assessmentprojetodebloco.stfApplication

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository

class LoginApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        LoginRepository.initialize()
        MobileAds.initialize(this)
    }
}