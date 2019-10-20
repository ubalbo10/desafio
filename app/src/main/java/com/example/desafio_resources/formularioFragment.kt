package com.example.desafio_resources


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class formularioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vista=inflater.inflate(R.layout.fragment_formulario, container, false)
        var btn_enviar=vista.findViewById<Button>(R.id.btn_enviar)
        var inp_nombre=vista.findViewById<EditText>(R.id.editText_nombre)
        var inp_correo=vista.findViewById<EditText>(R.id.editText_correo)
        btn_enviar.setOnClickListener {
            if(inp_nombre.text.toString().isEmpty()){
                Toast.makeText(activity,"nombre vacio",Toast.LENGTH_LONG).show()
            }else if (inp_correo.text.toString().isEmpty()){
                Toast.makeText(activity,"correo vacio",Toast.LENGTH_LONG).show()
            }


//            var comunicacion: ListenerFragment? =null
//                comunicacion=MainActivity()
//                comunicacion.envio()
//            var fragment=envioFragment()
//            val builder = activity?.supportFragmentManager
//                ?.beginTransaction()
//                ?.add(R.id.fragment_contenedor, fragment, MainActivity.FRAGMENT_TAG)
//            builder?.commit()


        }
        return vista

    }


}
