package com.example.primerparcial_natielloluciano

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var textViewEdad: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)


        textViewName = findViewById(R.id.textViewName)
        textViewEdad = findViewById(R.id.textViewEdad)
        imageView = findViewById(R.id.imageViewDetalle)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombre", "")
        val edad = bundle?.getString("edad", "")
        val url = bundle?.getString("url", "")

        Picasso.get().load(url.toString()).into(imageView)
        textViewName.text = nombre
        textViewEdad.text = "Edad: $edad"
    }
}