package sv.edu.desafio_resources


import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import sv.edu.bitlab.desafio.guillermo.Account
import sv.edu.bitlab.desafio.guillermo.AdapterListDetalle
import sv.edu.bitlab.desafio.guillermo.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

class CollectionViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vista=inflater.inflate(R.layout.fragment_collection_view, container, false)
        var recyclerView=vista.findViewById<RecyclerView>(R.id.recycler_account)
        var list_documentos= ArrayList<Account>()
        var db = FirebaseFirestore.getInstance()
        db.collection("accounts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")

                    var documentos = document.toObject(Account::class.java)

                    list_documentos!!.add(documentos!!)

                }

                Toast.makeText(activity,"${list_documentos.size}",Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }


//        var Account=ArrayList<Account>()

        var adaptador= AdapterListDetalle(list_documentos!!)
       recyclerView!!.adapter=adaptador
        recyclerView!!.layoutManager = LinearLayoutManager(activity!!.applicationContext, LinearLayoutManager.VERTICAL, false)



        return vista
    }


}
