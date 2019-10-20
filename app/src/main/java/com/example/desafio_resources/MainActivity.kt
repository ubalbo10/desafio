package com.example.desafio_resources


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(),ListenerFragment {
    override fun envio() {
        var fragment=envioFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_contenedor, fragment)
        transaction.addToBackStack(null)
        transaction.commit()




    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val spinner: Spinner = findViewById(R.id.spinner)
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.array_conocer,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }
        var fragment=formularioFragment()
        val builder = supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_contenedor, fragment, FRAGMENT_TAG)
        builder.commit()


    }
    companion object{
        const val FRAGMENT_TAG = "FRAGMENT_TAG"

    }
}
