package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val bundle = intent.extras
        if (bundle != null){
            val nombre = bundle.getString("name")

            tv_nombre.setText(nombre)
        }

        btn_InfoGeneral.setOnClickListener{
            var intent = Intent(this,InformacionGeneral::class.java)
            startActivity(intent)
        }

        btn_CitasMedicas.setOnClickListener{
            var intent = Intent(this,CategoriasCitas::class.java)
            startActivity(intent)
        }

        btn_localizar.setOnClickListener{
            var intent = Intent(this,Localizar::class.java)
            startActivity(intent)
        }
        btn_cerrar_sesion.setOnClickListener{
            finish()
            var intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }



    }


}
