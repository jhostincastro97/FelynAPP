package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_geriatria.*
import kotlinx.android.synthetic.main.activity_main.*

class Geriatria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geriatria)

        btn_A_Geratria_menu.setOnClickListener{
            var intent = Intent(this,CategoriasCitas::class.java)
            startActivity(intent)
        }
    }
}
