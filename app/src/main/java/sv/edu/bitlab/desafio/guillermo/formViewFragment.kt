package sv.edu.desafio_resources


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import sv.edu.bitlab.desafio.guillermo.R


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
                    listener!!.envio()
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



