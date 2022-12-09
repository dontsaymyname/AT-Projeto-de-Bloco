package com.pinheiro.michael.assessmentprojetodebloco.loginrepository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.pinheiro.michael.assessmentprojetodebloco.service.UserModel


const val TAG = "LoginSTF"

class LoginRepository private constructor() {
    companion object {
        lateinit var auth: FirebaseAuth
        lateinit var firestore: FirebaseFirestore
        lateinit var usersCollection: CollectionReference
        var userModel = UserModel()


        private var INSTANCE: LoginRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = LoginRepository()
            }
            auth = Firebase.auth
            firestore = Firebase.firestore
            usersCollection = firestore.collection("users")

            if (auth.currentUser != null) {
                setUserDocument()
            }

        }

        fun get(): LoginRepository {
            return INSTANCE
                ?: throw IllegalStateException(" TurmasRepository deve ser inicializado")

        }

        private fun setUserDocument() {
            val id = auth.currentUser!!.uid
            val user = usersCollection.document(id)
            user.get().addOnCompleteListener {
                if(it.isSuccessful){
                    userModel = it.result.toObject<UserModel>()!!
                }
            }
        }
    }


    fun getCurrentUser() = auth.currentUser

    fun isLoggedIn(): Boolean {
        if (getCurrentUser() != null) {
            return true
        }
        return false

    }
    fun updateUserModel(newUserModel: UserModel){
        userModel = newUserModel
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
        while (firstDeck.size < 12) {
            firstDeck.add((1..20).random())
        }
        usersCollection.document(userId).set(
            UserModel(
                id = userId,
                email = email,
                cardsIds = firstDeck.toList(),
                deck = firstDeck.toList().dropLast(5)
            )
        )
    }

    fun getUsersCollection() = usersCollection

    fun getUserModel() = userModel



    fun logout() {
        auth.signOut()

    }
}
