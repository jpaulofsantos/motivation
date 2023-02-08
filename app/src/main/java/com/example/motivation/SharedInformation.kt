package com.example.motivation

import android.content.Context
import android.content.SharedPreferences

class SharedInformation(context: Context) {
    private val sharedNome: SharedPreferences = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun saveName(chave: String, nome: String) {
        sharedNome.edit().putString(chave, nome).apply()
    }

    fun getName(chave: String): String {
        return sharedNome.getString(chave, "") ?: ""
    }
}