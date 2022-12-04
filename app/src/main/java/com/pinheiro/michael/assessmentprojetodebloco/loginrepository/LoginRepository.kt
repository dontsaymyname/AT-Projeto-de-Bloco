package com.pinheiro.michael.assessmentprojetodebloco.loginrepository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


const val TAG = "LoginSTF"

class LoginRepository private constructor() {
    companion object {
        lateinit var auth: FirebaseAuth


        private var INSTANCE: LoginRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = LoginRepository()
            }
            auth = Firebase.auth


        }
        fun get(): LoginRepository{
            return INSTANCE ?: throw IllegalStateException(" TurmasRepository deve ser inicializado")

        }



    }

    fun getCurrentUser() = auth.currentUser

    fun isLoggedIn(): Boolean{
        if(getCurrentUser()!=null){
            return true
        }
        return false

    }

    fun cadastrarUsuarioComSenha(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }
    fun login(email: String, password: String): Task<AuthResult> {
        //logar com firebase
        return auth.signInWithEmailAndPassword(email, password)
//

    }


    fun logout(){
        auth.signOut()

    }
}
