package sv.edu.desafio_resources


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



import sv.edu.bitlab.desafio.guillermo.R
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.DocumentReference
import com.google.android.gms.tasks.OnSuccessListener


import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.FirebaseFirestore

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.fragment.app.FragmentActivity.*


class MainActivity : AppCompatActivity(),
    formularioFragment.ComunicacionFragmentListener {
    override fun envio() {
        //Toast.makeText(this,"fragment in main",Toast.LENGTH_LONG).show()
        var fragment= CollectionViewFragment()
        val transicion = supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_contenedor, fragment,
                FRAGMENT_TAG
            )
        transicion.commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


// Add a new document with a generated ID

        var fragment= formularioFragment()
        val builder = supportFragmentManager
            .beginTransaction()
            .add(
                R.id.fragment_contenedor, fragment,
                FRAGMENT_TAG
            )
        builder.commit()




    }
    companion object{
        const val FRAGMENT_TAG = "FRAGMENT_TAG"

    }
}
