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


    }
}
