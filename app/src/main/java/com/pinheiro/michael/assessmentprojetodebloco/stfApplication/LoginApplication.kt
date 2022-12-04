package com.pinheiro.michael.assessmentprojetodebloco.stfApplication

import android.app.Application
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository

class LoginApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        LoginRepository.initialize()
    }
}