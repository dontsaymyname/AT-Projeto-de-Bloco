package com.pinheiro.michael.assessmentprojetodebloco.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import com.pinheiro.michael.assessmentprojetodebloco.MainActivity
import com.pinheiro.michael.assessmentprojetodebloco.R
import com.pinheiro.michael.assessmentprojetodebloco.databinding.ActivityLoginBinding
import com.pinheiro.michael.assessmentprojetodebloco.fragment_ext.getTextInputString
import com.pinheiro.michael.assessmentprojetodebloco.fragment_ext.toastMsg

class LoginActivity : AppCompatActivity() {
    val viewModel by viewModels<LoginViewModel>()


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }
    //////
    override fun onStart(){
        super.onStart()
        if(viewModel.isLoggedIn()){
            startMainActivity()
        }
    }

    fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
    private fun setup() {
        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        binding.apply {
            btnLogin.setOnClickListener {
                onSignInClick()
            }
            Signup.setOnClickListener{
                onSignOnClick()
            }
        }
    }

    private fun onSignOnClick() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    private fun onSignInClick() {
        val email = getTextInputString(binding.inputEmail)
        val password = getTextInputString(binding.inputPassword)
        signIn(email,password)
    }
    private fun signIn(email:String,password:String){
        viewModel.login(email,password)
            .addOnSuccessListener {
                toastMsg("logado com sucesso")
                startMainActivity()
            }
            .addOnFailureListener{
                toastMsg("Falha ao Logar\n${it.message}")
            }

    }



}