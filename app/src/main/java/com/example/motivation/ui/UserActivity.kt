package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.utils.MotivationConstants
import com.example.motivation.R
import com.example.motivation.utils.SharedInformation
import com.example.motivation.databinding.ActivityUserBinding

lateinit var bindingUserActivity: ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUserActivity = ActivityUserBinding.inflate(layoutInflater)
        setContentView(bindingUserActivity.root)

        bindingUserActivity.btnSalvar.setOnClickListener(this)
        supportActionBar?.hide()

        checkUser()


    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnSalvar) {
            save()
        }
    }

    private fun save() {
        var getNome = bindingUserActivity?.etNome?.text.toString()
        if (getNome.isBlank() || getNome == null) {
            Toast.makeText(this, "Favor preencher o nome!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Welcome $getNome!", Toast.LENGTH_SHORT).show()

            //salvando o nome para passar para MainActivity
            var sharedInformation = SharedInformation(this)
            sharedInformation.saveName(MotivationConstants.KEY.USER_NAME, getNome)

            //iniciando a MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            //encerrando a UserActivity
            finish()
        }
    }

    private fun checkUser() {

        var sharedInformation = SharedInformation(this).getName(MotivationConstants.KEY.USER_NAME)

        if (sharedInformation != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}