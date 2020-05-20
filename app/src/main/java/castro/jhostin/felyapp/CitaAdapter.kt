package castro.jhostin.felyapp

import android.annotation.SuppressLint
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.w3c.dom.Text

class CitaAdapter(val mCtx: Context, val layoutresid: Int, val listaCitas: List<Cita>) : ArrayAdapter<Cita>(mCtx, layoutresid, listaCitas) {

    @SuppressLint("SetTextI18n")
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
        nombre.text = "Nombre: "+cita.nombreEnfermo
        cedula.text = "# Cedula: "+cita.cedula
        direccion.text = "Direccion: " + cita.direccion
        telefono.text = "Telefono: "+cita.telefono
        clinica.text = "Clinica: "+cita.clinica
        numConsultorio.text = "# Consultorio: " +cita.numConsultorio
        fechaCita.text = " " + "Fecha: " +cita.fechaCita
        return view

    }


}