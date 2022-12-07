package com.pinheiro.michael.assessmentprojetodebloco.service

data class UserModel(
    val id: String = "",
    val email: String = "",
    val cardsIds: List<Int> = emptyList(),
    val deck: List<Int> = emptyList(),
) : java.io.Serializable