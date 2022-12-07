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

    fun retrieveDeck() = repository.getUserModel().deck


}
