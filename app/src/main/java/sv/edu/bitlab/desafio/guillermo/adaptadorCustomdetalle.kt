package sv.edu.bitlab.desafio.guillermo

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterListDetalle(items:ArrayList<Account>): RecyclerView.Adapter<AdapterListDetalle.ViewHolder>() {

    var ListDatos=ArrayList<Account>()

    init {
        this.ListDatos=items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterListDetalle.ViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.detalle_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ListDatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.asignarDatos(ListDatos[position])


    }

    class ViewHolder(itemView: View /**/) : RecyclerView.ViewHolder(itemView){
        var perfil=itemView.findViewById<TextView>(R.id.item_superior_perfil)
        var correo=itemView.findViewById<TextView>(R.id.item_correo)
        var numero=itemView.findViewById<TextView>(R.id.item_numero)
        var comoTeEnteraste=itemView.findViewById<TextView>(R.id.item_comoteenteraste)





        fun asignarDatos(datos: Account) {
//            relleno.text="${datos.conArroz+datos.conMaiz}-${datos.relleno}"
//            detalle.text="${(datos.conArroz+datos.conMaiz)*0.5}"
            perfil.text=datos.accountName
            correo.text=datos.accountEmail
            numero.text=datos.accountPhone
            comoTeEnteraste.text=datos.accountFoundOutBy

        }







    }
}


//adaptador=AdapterList(pupusa!!)
//        recyclerView!!.adapter=adaptador
//        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//        en la actividad pasar esto

