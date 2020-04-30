package castro.jhostin.felyapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val bundle = intent.extras
        if (bundle != null){
            val nombre = bundle.getString("name")
            val correo = bundle.getString("email")

            tv_nombre.setText("!Bienvenido(a)¡\n"+nombre)
            tv_correo.setText(correo)
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
        }

        btn_blog.setOnClickListener{
            var intent = Intent(this, BlogInteractivo::class.java)
            startActivity(intent)
        }

        btn_tips.setOnClickListener{
            var intent = Intent(this, TipsConsejos::class.java)
            startActivity(intent)
        }



    }


}
