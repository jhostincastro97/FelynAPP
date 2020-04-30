package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_categorias_citas.*
import kotlinx.android.synthetic.main.activity_menu.*

class CategoriasCitas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias_citas)

        btn_Geriatria.setOnClickListener{
            var intent = Intent(this,Geriatria::class.java)
            startActivity(intent)
        }
        btn_Cardiologia.setOnClickListener {
            var intent = Intent(this, Cardiologia::class.java)
            startActivity(intent)
        }

        btn_Neurologia.setOnClickListener {
            var intent = Intent(this, Neurologia::class.java)
            startActivity(intent)
        }

        btn_Psicologia.setOnClickListener{
            var intent = Intent(this,Psicologia::class.java)
            startActivity(intent)
        }

        btn_A_Menu_CategoriasCitas.setOnClickListener{
            var intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }

        btn_LabClinico.setOnClickListener{
            var intent = Intent(this,LabClinico::class.java)
            startActivity(intent)
        }

        btn_Reumatologia.setOnClickListener{
            var intent = Intent(this,Reumatologia::class.java)
            startActivity(intent)
        }

        btn_MedicoGeneral.setOnClickListener{
            var intent = Intent(this,MedicoGeneral::class.java)
            startActivity(intent)
        }

        btn_Odontologia.setOnClickListener{
            var intent = Intent(this,Odontologia::class.java)
            startActivity(intent)
        }

        btn_Ginecologia.setOnClickListener{
            var intent = Intent(this,Ginecologia::class.java)
            startActivity(intent)
        }

        btn_Urologia.setOnClickListener{
            var intent = Intent(this,Urologia::class.java)
            startActivity(intent)
        }

        btn_MedicinaInterna.setOnClickListener{
            var intent = Intent(this,MedicinaInterna::class.java)
            startActivity(intent)
        }


    }
}
