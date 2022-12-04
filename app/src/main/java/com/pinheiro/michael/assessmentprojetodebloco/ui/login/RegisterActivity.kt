package com.pinheiro.michael.assessmentprojetodebloco.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.pinheiro.michael.assessmentprojetodebloco.MainActivity
import com.pinheiro.michael.assessmentprojetodebloco.databinding.ActivityRegister2Binding
import com.pinheiro.michael.assessmentprojetodebloco.fragment_ext.getTextInputString
import com.pinheiro.michael.assessmentprojetodebloco.fragment_ext.toastMsg

class RegisterActivity : AppCompatActivity() {
    val viewModel by viewModels<LoginViewModel>()


    private lateinit var binding: ActivityRegister2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }
    // setup
    private fun setup(){
        setupClickOnListeners()
    }

    private fun setupClickOnListeners() {
        binding.apply {
            btnRegister.setOnClickListener {
                onSignOnClick()
            }
        }
    }

    private fun onSignOnClick() {
        binding.apply {
            val email = getTextInputString(inputEmail)
            val password = getTextInputString(inputPassword)
            val confirmaPassword = getTextInputString(inputConfirmPassword)
            if((password == confirmaPassword)&& password.length>5){
                signOn(email,password)
            }
        }
    }

    private fun signOn(email: String, password: String) {
        viewModel.signOn(email,password)
        viewModel.signOn(email,password)
            .addOnSuccessListener {
                toastMsg("cadastrado com sucesso")
                startMainActivity()
            }
            .addOnFailureListener {
                toastMsg("Falha ao Cadastrar \n${it.message}")
            }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}