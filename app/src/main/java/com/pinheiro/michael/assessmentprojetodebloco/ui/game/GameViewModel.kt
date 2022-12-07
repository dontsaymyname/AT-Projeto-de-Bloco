package com.pinheiro.michael.assessmentprojetodebloco.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.toObject
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository
import com.pinheiro.michael.assessmentprojetodebloco.service.CardModel
import com.pinheiro.michael.assessmentprojetodebloco.service.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private val repository = LoginRepository.get()

    private val _deck = MutableLiveData<List<Int>>()
    val deck: LiveData<List<Int>> = _deck
    var playerDeck = emptyList<Int>()



   fun retrieveDeck() = repository.getUserModel().deck

    fun getDeck(){
        val user = repository.getUsersCollection().document("UWrSroYYdLYCaTH8Lq7FZXQ5G412")
        user.get().addOnSuccessListener {document ->
            if (document != null) {
                println("not null")
                playerDeck = document.toObject<UserModel>()!!.deck
            } else {
                println("null")
            }
        }
            .addOnFailureListener { exception ->
                println("failure")
            }

//        repository.getUserDocument().get().addOnSuccessListener { document ->
//            val user = document.toObject<UserModel>()
//            playerDeck = user!!.deck
//        }.addOnFailureListener {
//            println("fail")
//            println("fail2")
//        }
    }


}
