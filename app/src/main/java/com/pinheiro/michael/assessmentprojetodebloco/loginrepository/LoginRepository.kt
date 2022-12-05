package com.pinheiro.michael.assessmentprojetodebloco.loginrepository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.pinheiro.michael.assessmentprojetodebloco.service.UserModel


const val TAG = "LoginSTF"

class LoginRepository private constructor() {
    companion object {
        lateinit var auth: FirebaseAuth
        lateinit var firestore: FirebaseFirestore
        lateinit var usersCollection: CollectionReference


        private var INSTANCE: LoginRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = LoginRepository()
            }
            auth = Firebase.auth
            firestore = Firebase.firestore
            usersCollection = firestore.collection("users")


        }

        fun get(): LoginRepository {
            return INSTANCE
                ?: throw IllegalStateException(" TurmasRepository deve ser inicializado")

        }


    }

    fun getCurrentUser() = auth.currentUser

    fun isLoggedIn(): Boolean {
        if (getCurrentUser() != null) {
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

    fun createUser(userId: String, email: String) {
        val firstDeck = mutableSetOf<Int>()
        while(firstDeck.size < 7){
            firstDeck.add((1..50).random())
        }
        usersCollection.document(userId).set(UserModel(id = userId, email = email, cardsIds = firstDeck.toList()))
    }

    fun addInitialDeck(userId: String) {
        usersCollection.document(userId).collection("cards").add(1)
    }


    fun logout() {
        auth.signOut()

    }
}
