package com.example.primerparcial_natielloluciano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var botonAccion : Button
    private lateinit var nombreUsuario  : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonAccion = findViewById(R.id.buttonLogin)
        nombreUsuario = findViewById(R.id.editTextNombre)

        val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
        val nombreUsuarioPreference = preferences.getString("name", "")

        if (nombreUsuarioPreference != null){
            if (!nombreUsuarioPreference.isEmpty()){
                val intent = Intent(this, listadoActivity::class.java)
                startActivity(intent)
            }
        }

        botonAccion.setOnClickListener {

            if (nombreUsuario.text.isNullOrEmpty()){
                Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val nombre = nombreUsuario.text.toString()
                val editor = preferences.edit()
                editor.putString("name",nombre)
                editor.apply()
                val intent = Intent(this, listadoActivity:: class.java)
                startActivity(intent)

            }
        }


    }
}