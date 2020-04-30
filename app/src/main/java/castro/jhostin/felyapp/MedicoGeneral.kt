package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lab_clinico.*
import kotlinx.android.synthetic.main.activity_medico_general.*

class MedicoGeneral : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medico_general)

        btn_A_MedicoGeneral_menu.setOnClickListener{
            var intent = Intent(this,CategoriasCitas::class.java)
            startActivity(intent)
        }
    }
}
