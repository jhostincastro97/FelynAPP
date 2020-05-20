package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import castro.jhostin.felyapp.DB.DBHelper

class imprime_datosIG : AppCompatActivity() {
    private val dbHandler = DBHelper(this, null)
    var dataList = ArrayList<HashMap<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imprime_datos_i_g)
    }

    private fun loadIntoList() {
        dataList.clear()
        val cursor = dbHandler.getAllRow()
        cursor!!.moveToFirst()

        while (!cursor.isAfterLast) {
            val map = HashMap<String, String>()
            map["id"] = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ID))
            map["nombre"] = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NOMBRE))
            map["edad"] = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_EDAD))
            map["enfermedad"] = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ENFERMEDAD))
            map["grado_de_enfermedad"] =
                cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_GRADO_ENFERMEDAD))
            map["tipo_de_sangre"] =
                cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TIPO_DE_SANGRE))
            map["estatura"] = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ESTATURA))
            map["peso"] = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PESO))
            map["alergias"] = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ALERGIAS))
            map["servicio_medico"] =
                cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_SERVICIO_MEDICO))
            map["numero_seguro_social"] =
                cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NUMERO_SEGURO_SOCIAL))
            map["diagnostico_medico"] =
                cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DIAGNOSTICO))

            dataList.add(map)
            cursor.moveToNext()
        }

        findViewById<ListView>(R.id.listView).adapter = CustomAdapterIG(this@imprime_datosIG, dataList)
        findViewById<ListView>(R.id.listView).setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this, InformacionGeneral::class.java)
            intent.putExtra("id", dataList[+i]["id"])
            intent.putExtra("et_nombre", dataList[+i]["nombre"])
            intent.putExtra("et_edad", dataList[+i]["edad"])
            intent.putExtra("et_grado_enfermedad", dataList[+i]["grado_de_enfermedad"])
            intent.putExtra("et_tipo_de_sangre", dataList[+i]["tipo_de_sangre"])
            intent.putExtra("et_estatura", dataList[+i]["estatura"])
            intent.putExtra("et_peso", dataList[+i]["peso"])
            intent.putExtra("et_alergias", dataList[+i]["alergias"])
            intent.putExtra("et_servicio_medico", dataList[+i]["servicio_medico"])
            intent.putExtra("et_no_seguro_social", dataList[+i]["numero_seguro_social"])
            intent.putExtra("et_descripcion_medica", dataList[+i]["diagnostico_medico"])

            startActivity(intent)
        }
    }

    fun fabClicked(v: View){
        val intent = Intent(this, InformacionGeneral::class.java)
        startActivity(intent)
    }

    public override fun onResume() {
        super.onResume()
        loadIntoList()

    }
}
