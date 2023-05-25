package com.example.primerparcial_natielloluciano

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class listadoActivity : AppCompatActivity() {
    private lateinit var botonLogout : Button
    private lateinit var textoNombre : TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AlumnoAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)


        botonLogout = findViewById(R.id.buttonLogout)
        textoNombre = findViewById(R.id.textViewNombreEnListado)
        val preferences = getSharedPreferences("loginPref",MODE_PRIVATE)

        textoNombre.text = "Hola " + preferences.getString("name", "")

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = AlumnoAdapter(applicationContext)
        recyclerView.adapter = adapter
        adapter.submitList(getListadoAlumnos())

        adapter.onItemClickListener = { alumno ->
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("nombre", alumno.nombre)
            intent.putExtra("edad", alumno.edad.toString())
            intent.putExtra("url", alumno.foto)
            startActivity(intent)
        }

        botonLogout.setOnClickListener {

            preferences.edit().clear().apply()

            val intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }
    }

    private fun getListadoAlumnos(): MutableList<Alumno>{
        return mutableListOf(
            Alumno(1, "Alejandra", 30, "https://www.prospectfactory.com.mx/wp-content/uploads/2015/12/atraer-mas-alumnos-1.jpg"),
            Alumno(2, "Fabio", 29, "https://img.freepik.com/foto-gratis/retrato-estudiante-guapo-sonriendo_23-2148586538.jpg?t=st=1684702779~exp=1684703379~hmac=a28b78c223c473d4fcf2e7ce06621f8986007632c07143c8b39c53a3a55a451b"),
            Alumno(3, "Carla", 25, "https://img.freepik.com/foto-gratis/bonita-adolescente-feliz-volver-universidad_23-2148586588.jpg?w=1380&t=st=1684702779~exp=1684703379~hmac=f45d94414e6dc100a2f57a164ed0efdb934cf521ee10192d2a19f2e7f09db653"),
            Alumno(4, "Lidia", 30, "https://www.prospectfactory.com.mx/wp-content/uploads/2015/12/atraer-mas-alumnos-1.jpg"),
            Alumno(5, "Esteban", 29, "https://img.freepik.com/foto-gratis/retrato-estudiante-guapo-sonriendo_23-2148586538.jpg?t=st=1684702779~exp=1684703379~hmac=a28b78c223c473d4fcf2e7ce06621f8986007632c07143c8b39c53a3a55a451b"),
            Alumno(6, "Lorena", 25, "https://img.freepik.com/foto-gratis/bonita-adolescente-feliz-volver-universidad_23-2148586588.jpg?w=1380&t=st=1684702779~exp=1684703379~hmac=f45d94414e6dc100a2f57a164ed0efdb934cf521ee10192d2a19f2e7f09db653"),
            Alumno(7, "Gimena", 43, "https://www.prospectfactory.com.mx/wp-content/uploads/2015/12/atraer-mas-alumnos-1.jpg"),
            Alumno(8, "Fabian", 44, "https://img.freepik.com/foto-gratis/retrato-estudiante-guapo-sonriendo_23-2148586538.jpg?t=st=1684702779~exp=1684703379~hmac=a28b78c223c473d4fcf2e7ce06621f8986007632c07143c8b39c53a3a55a451b"),
            Alumno(9, "Ernestina", 32, "https://img.freepik.com/foto-gratis/bonita-adolescente-feliz-volver-universidad_23-2148586588.jpg?w=1380&t=st=1684702779~exp=1684703379~hmac=f45d94414e6dc100a2f57a164ed0efdb934cf521ee10192d2a19f2e7f09db653"),
            Alumno(10, "Julia", 20, "https://www.prospectfactory.com.mx/wp-content/uploads/2015/12/atraer-mas-alumnos-1.jpg"),
            Alumno(11, "Franco", 39, "https://img.freepik.com/foto-gratis/retrato-estudiante-guapo-sonriendo_23-2148586538.jpg?t=st=1684702779~exp=1684703379~hmac=a28b78c223c473d4fcf2e7ce06621f8986007632c07143c8b39c53a3a55a451b"),
            Alumno(12, "Carla", 24, "https://img.freepik.com/foto-gratis/bonita-adolescente-feliz-volver-universidad_23-2148586588.jpg?w=1380&t=st=1684702779~exp=1684703379~hmac=f45d94414e6dc100a2f57a164ed0efdb934cf521ee10192d2a19f2e7f09db653"),

        )
    }
}