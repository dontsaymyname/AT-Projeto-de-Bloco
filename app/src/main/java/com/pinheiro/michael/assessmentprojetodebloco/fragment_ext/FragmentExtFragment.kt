package com.pinheiro.michael.assessmentprojetodebloco.fragment_ext

import android.app.Activity
import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController



fun Activity.toastMsg(msg: String){
    Toast.makeText(this,
        msg,
        Toast.LENGTH_SHORT

    ).show()
}

fun Fragment.toastFrag(msg: String) {
    Toast.makeText(
        requireContext(),
        msg,
        Toast.LENGTH_SHORT
    ).show()
}

fun Fragment.navUpFrag() {
    findNavController().navigateUp()
}

fun Activity.getTextInputString(editText: EditText):String{
    return editText.text.toString()
}

fun Activity.getIntInputString(editText: EditText):Int{
    return editText.text.toString().toInt()
}

fun Fragment.nav(id: Int){
    findNavController().navigate(id)
}