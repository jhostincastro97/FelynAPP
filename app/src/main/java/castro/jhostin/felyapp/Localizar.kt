package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_localizar.*
import kotlinx.android.synthetic.main.activity_menu.*

class Localizar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localizar)

        btn_A_Localizar_menu.setOnClickListener{
            var intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }

    }



}
