package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cardiologia.*
import kotlinx.android.synthetic.main.activity_urologia.*

class Urologia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urologia)

        btn_A_Urologia_menu.setOnClickListener{
            var intent = Intent(this,CategoriasCitas::class.java)
            startActivity(intent)
        }
    }
}
