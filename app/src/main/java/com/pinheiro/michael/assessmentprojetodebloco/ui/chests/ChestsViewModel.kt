package com.pinheiro.michael.assessmentprojetodebloco.ui.chests

import androidx.lifecycle.ViewModel
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository

class ChestsViewModel : ViewModel() {

    val repository = LoginRepository.get()

    fun addNewCart(){
        repository.addNewCard()
    }

}