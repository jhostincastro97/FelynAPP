package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lab_clinico.*
import kotlinx.android.synthetic.main.activity_reumatologia.*

class Reumatologia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reumatologia)

        btn_A_Reumatologia_menu.setOnClickListener{
            var intent = Intent(this,CategoriasCitas::class.java)
            startActivity(intent)
        }

    }
}
