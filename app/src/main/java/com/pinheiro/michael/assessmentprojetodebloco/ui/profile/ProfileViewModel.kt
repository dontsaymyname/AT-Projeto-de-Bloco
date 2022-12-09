package com.pinheiro.michael.assessmentprojetodebloco.ui.profile

import androidx.lifecycle.ViewModel
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository
import com.pinheiro.michael.assessmentprojetodebloco.service.findCards

class ProfileViewModel : ViewModel() {

    private val repository = LoginRepository.get()

    fun retrieveDeck() = repository.getUserModel().deck.findCards()

    fun retrieveUserInfo() = repository.getUserModel()

    fun updateDeck(newDeck: List<Int>) {
        val userModel = repository.getUserModel().copy(deck = newDeck)
        repository.getUsersCollection().document(userModel.id).set(userModel)
        repository.updateUserModel(userModel)
    }
}