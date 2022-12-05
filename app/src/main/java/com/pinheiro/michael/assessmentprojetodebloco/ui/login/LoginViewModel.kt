package com.pinheiro.michael.assessmentprojetodebloco.ui.login

import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.pinheiro.michael.assessmentprojetodebloco.loginrepository.LoginRepository

class LoginViewModel: ViewModel() {

    val TAG = "ViewModel"
    val repository = LoginRepository.get()
    // auth
    fun  isLoggedIn(): Boolean {
        return repository.isLoggedIn()
    }
    fun login(email: String, password:String): Task<AuthResult> {
        return LoginRepository.auth.signInWithEmailAndPassword(email,password)
    }
    fun signOn(email:String,password:String): Task<AuthResult> {
        return repository.cadastrarUsuarioComSenha(
            email,
            password
        ).addOnSuccessListener {
            repository.createUser(it.user!!.uid, it.user!!.email!!)
        }
    }


}