package sv.edu.desafio_resources


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.storage.UploadTask
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.StorageReference

import android.net.Uri
import android.os.Handler
import sv.edu.bitlab.desafio.guillermo.R
import java.io.File
import com.google.firebase.firestore.DocumentReference

import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.core.view.isGone
import kotlinx.android.synthetic.main.fragment_formulario.*
import sv.edu.bitlab.desafio.guillermo.Account


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class formularioFragment : Fragment() {

    var listener: ComunicacionFragmentListener?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var n=0
        var vista=inflater.inflate(R.layout.fragment_formulario, container, false)
        var btn_enviar=vista.findViewById<Button>(R.id.btn_enviar)
        var inp_nombre=vista.findViewById<EditText>(R.id.editText_nombre)
        var inp_correo=vista.findViewById<EditText>(R.id.editText_correo)
        var inp_telefono=vista.findViewById<EditText>(R.id.editText_numero)
        var enlace=vista.findViewById<TextView>(R.id.enlace_coleccion)
        enlace.setOnClickListener{
            listener!!.envio()

        }
        btn_enviar.setOnClickListener {


                if(inp_nombre.text.toString().isEmpty()){
                    Toast.makeText(activity,"nombre vacio",Toast.LENGTH_LONG).show()
                    n=1
                }else if (inp_correo.text.toString().isEmpty()){
                    Toast.makeText(activity,"correo vacio",Toast.LENGTH_LONG).show()
                    n=1
                }else{
                    n=0
                }

                if(n!=1){
                    // Access a Cloud Firestore instance from your Activity
                    var db = FirebaseFirestore.getInstance()
                    var mStorageRef = FirebaseStorage.getInstance().getReference()
                    var objeto=Account("","","","","")
                    objeto!!.accountName=inp_nombre.toString()
                    objeto!!.accountEmail=inp_correo.toString()
                    objeto!!.accountPhone=inp_telefono.toString()
                    Toast.makeText(activity,"me estoy ejecutando",Toast.LENGTH_LONG).show()
//
//                    db.collection("cities").document("LA")
//                        .set(city)
//                        .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
//                        .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
                    db.collection("accounts").document("nuevo").set(objeto)
                        .addOnSuccessListener { //documentReference ->
                            Log.d(
                                TAG,
                                "DocumentSnapshot added with ID: " //+ documentReference.id
                            )
                            Toast.makeText(activity,"En evento de guardar",Toast.LENGTH_LONG).show()
                            listener!!.envio()
                        }
                        .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e)
                            Toast.makeText(activity,"Fallo guardar",Toast.LENGTH_LONG).show()
                        }

                    var contenedor_form=vista.findViewById<View>(R.id.contenedor_form)
                    var contenedor_espera=vista.findViewById<View>(R.id.contenedor_espera)
                    contenedor_form.visibility=View.GONE
                    contenedor_espera.visibility=View.VISIBLE

                    Handler().postDelayed({
                        listener!!.envio()
                    }, 3000)

                }


        }
        return vista

    }

    interface ComunicacionFragmentListener {
        // TODO: Update argument type and name
        fun envio()

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ComunicacionFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OrdenDetalleFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


}



