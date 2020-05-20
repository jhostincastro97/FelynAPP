package castro.jhostin.felyapp

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.w3c.dom.Text

class CitaAdapter(val mCtx: Context, val layoutresid: Int, val listaCitas: List<Cita>) : ArrayAdapter<Cita>(mCtx, layoutresid, listaCitas) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutresid, null)

        val nombre = view.findViewById<TextView>(R.id.txtNombre)
        val cedula = view.findViewById<TextView>(R.id.txtCedula)
        val direccion = view.findViewById<TextView>(R.id.txtDireccion)
        val telefono = view.findViewById<TextView>(R.id.txtTelefono)
        val clinica = view.findViewById<TextView>(R.id.txtClinica)
        val numConsultorio = view.findViewById<TextView>(R.id.txtNumConsultorio)
        val fechaCita = view.findViewById<TextView>(R.id.txtFechaCita)
        val cita = listaCitas[position]
        nombre.text = cita.nombreEnfermo
        cedula.text = cita.cedula
        direccion.text = cita.direccion
        telefono.text = cita.telefono
        clinica.text = cita.clinica
        numConsultorio.text = cita.numConsultorio
        fechaCita.text = cita.fechaCita
        return view

    }


}