package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_geriatria.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class Geriatria : AppCompatActivity(), View.OnClickListener {
    private lateinit var etNombre : EditText
    private lateinit var etCedula : EditText
    private lateinit var etDireccion : EditText
    private lateinit var etTelefono : EditText
    private lateinit var etClinica : EditText
    private lateinit var etNumConsultorio : EditText
    private lateinit var datePicker: DatePicker
    private lateinit var database: DatabaseReference


    private lateinit var btnGuardarCita: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geriatria)
        etNombre = findViewById(R.id.txt_Nombre)
        etCedula = findViewById(R.id.txt_Cedula)
        etDireccion = findViewById(R.id.txt_Direccion)
        etTelefono = findViewById(R.id.txt_Telefono)
        etClinica = findViewById(R.id.txt_Clinica)
        etNumConsultorio = findViewById(R.id.txt_numConsultorio)
        datePicker = findViewById<DatePicker>(R.id.date_Picker)
        btnGuardarCita = findViewById(R.id.btn_AgregarCita)
        btnGuardarCita.setOnClickListener(this)
        database = FirebaseDatabase.getInstance().reference
        btn_A_Geratria_menu.setOnClickListener{
            var intent = Intent(this,CategoriasCitas::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        saveData()
    }


    private fun saveData() {
        val nombre: String = etNombre.text.toString().trim()
        val cedula: String = etCedula.text.toString().trim()
        val direccion: String = etDireccion.text.toString().trim()
        val telefono: String = etTelefono.text.toString().trim()
        val clinica: String = etClinica.text.toString().trim()
        val numConsultorio: String = etNumConsultorio.text.toString().trim()
        val builder = StringBuffer()
        builder.append("Fecha Cita: ")
        builder.append(datePicker.dayOfMonth.toString()+ "/")
        builder.append((datePicker.month + 1).toString() + "/")
        builder.append(datePicker.year)
        val fechaCita = builder.toString()
        val cita = Cita(UUID.randomUUID(),nombre, cedula, direccion, telefono, clinica, numConsultorio, fechaCita)
        database.child("citas").child(cita.id.toString()).setValue(cita)
    }
}
