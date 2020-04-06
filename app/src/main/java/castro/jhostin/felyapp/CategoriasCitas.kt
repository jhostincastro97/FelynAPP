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

    }
}
