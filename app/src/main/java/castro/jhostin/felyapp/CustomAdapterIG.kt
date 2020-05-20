package castro.jhostin.felyapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapterIG (private val context: Context,
                       private val dataList: ArrayList<HashMap<String, String>>) : BaseAdapter() {

    private val inflater: LayoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int { return dataList.size }
    override fun getItem(position: Int): Int { return position }
    override fun getItemId(position: Int): Long { return position.toLong() }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var dataitem = dataList[position]

        val rowView = inflater.inflate(R.layout.list_row_impresion_datos, parent, false)
        rowView.findViewById<TextView>(R.id.row_nombre).text = dataitem["nombre"]
        rowView.findViewById<TextView>(R.id.row_edad).text = "Edad: " + dataitem["edad"]
        rowView.findViewById<TextView>(R.id.row_enfermedad).text = "Enfermedad: " + dataitem["enfermedad"]
        rowView.findViewById<TextView>(R.id.row_grado_enfermedad).text = "Grado enfermedad: " + dataitem["grado_de_enfermedad"]
        rowView.findViewById<TextView>(R.id.row_tipo_de_sangre).text = "Tipo de sangre: " + dataitem["tipo_de_sangre"]
        rowView.findViewById<TextView>(R.id.row_estatura).text = "Estatura: " + dataitem["estatura"]
        rowView.findViewById<TextView>(R.id.row_peso).text = "Peso: " + dataitem["peso"]
        rowView.findViewById<TextView>(R.id.row_alergias).text = "Alergias: " + dataitem["alergias"]
        rowView.findViewById<TextView>(R.id.row_alergias).text = "Servicio Medico: " + dataitem["servicio_medico"]
        rowView.findViewById<TextView>(R.id.row_alergias).text = "No seguro social: " + dataitem["numero_seguro_social"]
        rowView.findViewById<TextView>(R.id.row_alergias).text = "Diagnostico Medico: " + dataitem["diagnostico_medico"]

        rowView.tag = position
        return rowView
    }
}
