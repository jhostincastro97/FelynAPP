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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informaciongeneral)

        btn_AMenu.setOnClickListener {
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        }





    }




