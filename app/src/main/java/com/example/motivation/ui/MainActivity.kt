package com.example.motivation.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.R
import com.example.motivation.data.PhraseMock
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.utils.MotivationConstants
import com.example.motivation.utils.SharedInformation

lateinit var binding: ActivityMainBinding
private var categoryId: Int = 0

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        handleFilter(R.id.ivLeft)
        //handlePhrase2(categoryId)
        handlePhrase3(categoryId)

        binding.btnFrase.setOnClickListener(this)
        binding.ivLeft.setOnClickListener(this)
        binding.ivCenter.setOnClickListener(this)
        binding.ivRight.setOnClickListener(this)
        binding.tvNome.setOnClickListener(this)

        //buscando o nome de UserActivity e setando o nome no textView através da chave "nomeLogin"

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        showUserName()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(view: View) {
        if (view.id in listOf(R.id.ivLeft, R.id.ivCenter, R.id.ivRight)) {
            handleFilter(view.id)
        } else if (view.id == R.id.btnFrase) {
            //binding.tv2.text = handlePhrase(categoryId)
            //handlePhrase2(categoryId)
            handlePhrase3(categoryId)
        } else if (view.id == R.id.tvNome) {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    private fun showUserName() {
        binding.tvNome.text = SharedInformation(this).getName(MotivationConstants.KEY.USER_NAME) + "!"
    }

    private fun handleFilter(id: Int) {

        binding.ivLeft.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.ivCenter.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.ivRight.setColorFilter(ContextCompat.getColor(this, R.color.black))

        if (id == R.id.ivLeft) {
            binding.ivLeft.setColorFilter(ContextCompat.getColor(this, R.color.white))
            categoryId = MotivationConstants.FILTER.LEFT
        } else if (id == R.id.ivCenter) {
            binding.ivCenter.setColorFilter(ContextCompat.getColor(this, R.color.white))
            categoryId = MotivationConstants.FILTER.CENTER

        } else if (id == R.id.ivRight) {
            binding.ivRight.setColorFilter(ContextCompat.getColor(this, R.color.white))
            categoryId = MotivationConstants.FILTER.RIGHT
        }
    }

    //forma 1 de gerar a frase aleatória
    private fun handlePhrase(id: Int): String {
        var lista = PhraseMock()
        return lista.ramdomPhrase(id).description
    }

    //forma 2 de gerar a frase aleatória
    private fun handlePhrase2(id: Int) {
       var lista = PhraseMock()
        binding.tv2.text = lista.getPhrase(id)
    }

    //forma 3 de gerar a frase aleatoria com a condição do left icon filtrar a lista toda
    private fun handlePhrase3(id: Int) {
        var lista = PhraseMock()
        binding.tv2.text = lista.ramdomPhraseAll(id).description
    }
}