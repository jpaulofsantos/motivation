package com.example.motivation.ui

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
        binding.tv2.text = handlePhrase(categoryId)

        binding.btnFrase.setOnClickListener(this)
        binding.ivLeft.setOnClickListener(this)
        binding.ivCenter.setOnClickListener(this)
        binding.ivRight.setOnClickListener(this)

        //buscando o nome de UserActivity e setando o nome no textView através da chave "nomeLogin"
        binding.tvNome.text = SharedInformation(this).getName(MotivationConstants.KEY.USER_NAME) + "!"
    }

    override fun onClick(view: View) {
        if (view.id in listOf(R.id.ivLeft, R.id.ivCenter, R.id.ivRight)) {
            handleFilter(view.id)
        } else if (view.id == R.id.btnFrase) {
            binding.tv2.text = handlePhrase(categoryId)
        }
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

    private fun handlePhrase(id: Int): String {
        var lista = PhraseMock()
        return lista.list(id).description
    }
}