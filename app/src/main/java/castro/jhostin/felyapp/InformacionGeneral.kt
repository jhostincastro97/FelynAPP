package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import castro.jhostin.felyapp.DB.DBHelper
import kotlinx.android.synthetic.main.activity_comentario_blog.*
import kotlinx.android.synthetic.main.activity_informaciongeneral.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class InformacionGeneral : AppCompatActivity() {
    val dbHandler = DBHelper(this, null)
    lateinit var modifyId: String
    lateinit var nombreEditText: EditText
    lateinit var edadEditText: EditText
    lateinit var enfermedadEditText: EditText
    lateinit var gradoEnfermedadEditText: EditText
    lateinit var Tipo_de_sangreEditText: EditText
    lateinit var estaturaEditText: EditText
    lateinit var pesoEditText: EditText
    lateinit var alergiasEditText: EditText
    lateinit var servicioMedicoEditText: EditText
    lateinit var noSeguroSocialEditText: EditText
    lateinit var diagnosticoMedicoEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informaciongeneral)

        btn_AMenu.setOnClickListener {
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

            nombreEditText = findViewById(R.id.row_nombre)
            edadEditText = findViewById(R.id.row_edad)
            enfermedadEditText = findViewById(R.id.row_enfermedad)

            gradoEnfermedadEditText = findViewById(R.id.row_grado_enfermedad)
            Tipo_de_sangreEditText = findViewById(R.id.row_tipo_de_sangre)
            estaturaEditText = findViewById(R.id.row_estatura)

            pesoEditText = findViewById(R.id.row_peso)
            alergiasEditText = findViewById(R.id.row_alergias)
            servicioMedicoEditText = findViewById(R.id.row_servicio_medico)

            noSeguroSocialEditText = findViewById(R.id.row_no_seguro_social)
            diagnosticoMedicoEditText = findViewById(R.id.row_diagnostico_medico)

            /* Check  if activity opened from List Item Click */
            if (intent.hasExtra("id")) {
                modifyId = intent.getStringExtra("id")
                nombreEditText.setText(intent.getStringExtra("nombre"))
                edadEditText.setText(intent.getStringExtra("edad"))
                enfermedadEditText.setText(intent.getStringExtra("enfermedad"))
                gradoEnfermedadEditText.setText(intent.getStringExtra("grado_de_enfermedad"))
                Tipo_de_sangreEditText.setText(intent.getStringExtra("tipo_de_sangre"))
                estaturaEditText.setText(intent.getStringExtra("estatura"))
                pesoEditText.setText(intent.getStringExtra("peso"))
                alergiasEditText.setText(intent.getStringExtra("alergias"))
                servicioMedicoEditText.setText(intent.getStringExtra("servicio_medico"))
                noSeguroSocialEditText.setText(intent.getStringExtra("numero_seguro_social"))
                diagnosticoMedicoEditText.setText(intent.getStringExtra("diagnostico_medico"))

                findViewById<Button>(R.id.btn_GuardarIG).visibility = View.GONE
            } else {
                findViewById<Button>(R.id.btnEditarIG).visibility = View.GONE
//            findViewById<Button>(R.id.btnDelete).visibility = View.GONE
            }


        }
        //metodos Agregar y Actualizar

        fun add(v: View) {
            val nombre = nombreEditText.text.toString()
            val edad = edadEditText.text.toString()
            val enfermedad = enfermedadEditText.text.toString()
            val grado_enfermedad = gradoEnfermedadEditText.text.toString()
            val tipo_de_sangre = Tipo_de_sangreEditText.text.toString()
            val estatura = estaturaEditText.text.toString()
            val peso = pesoEditText.text.toString()
            val alergias = alergiasEditText.text.toString()
            val serv_medico = servicioMedicoEditText.text.toString()
            val no_seguro_social = noSeguroSocialEditText.text.toString()
            val diagno_medico = diagnosticoMedicoEditText.text.toString()

            dbHandler.insertRow(
                nombre,
                edad,
                enfermedad,
                grado_enfermedad,
                tipo_de_sangre,
                estatura,
                peso,
                alergias,
                serv_medico,
                no_seguro_social,
                diagno_medico
            )
            Toast.makeText(this, "Datos agregados", Toast.LENGTH_SHORT).show()
            finish()
        }

        fun update(v: View) {
            val nombre = nombreEditText.text.toString()
            val edad = edadEditText.text.toString()
            val enfermedad = enfermedadEditText.text.toString()
            val grado_enfermedad = gradoEnfermedadEditText.text.toString()
            val tipo_de_sangre = Tipo_de_sangreEditText.text.toString()
            val estatura = estaturaEditText.text.toString()
            val peso = pesoEditText.text.toString()
            val alergias = alergiasEditText.text.toString()
            val serv_medico = servicioMedicoEditText.text.toString()
            val no_seguro_social = noSeguroSocialEditText.text.toString()
            val diagno_medico = diagnosticoMedicoEditText.text.toString()
            dbHandler.updateRow(
                modifyId,
                nombre,
                edad,
                enfermedad,
                grado_enfermedad,
                tipo_de_sangre,
                estatura,
                peso,
                alergias,
                serv_medico,
                no_seguro_social,
                diagno_medico
            )
            Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show()
            finish()
        }



    }




