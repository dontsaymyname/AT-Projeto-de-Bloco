package com.pinheiro.michael.assessmentprojetodebloco.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository
import com.pinheiro.michael.assessmentprojetodebloco.service.CardModel
import com.pinheiro.michael.assessmentprojetodebloco.service.findCards

class ProfileViewModel : ViewModel() {

    private val repository = LoginRepository.get()

    private val _cards = MutableLiveData<List<CardModel>>()
    val cards: LiveData<List<CardModel>> = _cards

    fun retrieveDeck() = repository.getUserModel().deck.findCards()

    fun retrieveUserInfo() = repository.getUserModel()

    fun updateCards(){
        _cards.value = retrieveUserInfo().cardsIds.findCards()
    }

    fun updateDeck(newDeck: List<Int>) {
        val userModel = repository.getUserModel().copy(deck = newDeck)
        repository.getUsersCollection().document(userModel.id).set(userModel)
        repository.updateUserModel(userModel)
    }
}