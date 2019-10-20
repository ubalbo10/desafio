package com.example.desafio_resources


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
