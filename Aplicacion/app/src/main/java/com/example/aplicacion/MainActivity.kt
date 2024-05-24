package com.example.aplicacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var ett: EditText
    lateinit var etm: EditText
    lateinit var btnguardar: Button
    lateinit var listaTareas: RecyclerView
    lateinit var adapter: TareasAdapter

    private val TareasViewModel:TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ett = findViewById(R.id.ett)
        etm = findViewById(R.id.etm)
        btnguardar = findViewById(R.id.btnguardar)
        listaTareas = findViewById(R.id.rvtareas)

        adapter = TareasAdapter(TareasViewModel.elementos)

        listaTareas.adapter = adapter
        listaTareas.layoutManager = GridLayoutManager(this,1)


        btnguardar.setOnClickListener {

            val titulo = ett.text.toString()
            val mensaje = etm.text.toString()

            TareasViewModel.elementos.add(Tarea(titulo,mensaje,false))

            adapter.notifyDataSetChanged()
            Toast.makeText(this,"${TareasViewModel.elementos.size}", Toast.LENGTH_SHORT).show()
        }

    }
}