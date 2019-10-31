package sv.edu.bitlab.desafio.guillermo

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterListDetalle(items:ArrayList<Pupusa>): RecyclerView.Adapter<AdapterListDetalle.ViewHolder>() {

    var ListDatos=ArrayList<Pupusa>()

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

        var relleno=itemView.findViewById<TextView>(R.id.txtrelleno)
        var detalle=itemView.findViewById<TextView>(R.id.txtdetallerelleno)





        fun asignarDatos(datos: Pupusa) {
            relleno.text="${datos.conArroz+datos.conMaiz}-${datos.relleno}"
            detalle.text="${(datos.conArroz+datos.conMaiz)*0.5}"

        }







    }
}


//adaptador=AdapterList(pupusa!!)
//        recyclerView!!.adapter=adaptador
//        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//        en la actividad pasar esto

