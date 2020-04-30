package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cardiologia.*
import kotlinx.android.synthetic.main.activity_medicina_interna.*

class MedicinaInterna : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicina_interna)

        btn_A_MedInterna_menu.setOnClickListener{
            var intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
