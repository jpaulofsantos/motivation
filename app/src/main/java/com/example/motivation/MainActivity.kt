package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.ivLeft.setOnClickListener(this)

        //buscando o nome de UserActivity e setando o nome no textView através da chave "nomeLogin"
        binding.tvNome.text = SharedInformation(this).getName("nomeLogin") + "!"


    }

    override fun onClick(view: View) {
        if (view.id == R.id.ivLeft) {
            R.drawable.ic_baseline_self_improvement_24
        }
    }
}