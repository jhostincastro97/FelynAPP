package castro.jhostin.felyapp

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_localizar.*
import java.time.Instant
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.hours
import kotlin.time.minutes

class Localizar : AppCompatActivity() {
         lateinit var btn: Button

//    var localizarPaciente = Intent(this,Ubicar_paciente::class.java)

    @ExperimentalTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localizar)
        btn_alerta.setOnClickListener{
            intent = Intent(applicationContext,Suena_alarma::class.java)
            startActivity(intent)

        }


         //sonar alarma
        btn = findViewById(R.id.btn_un_minuto)
        btn.setOnClickListener{
         createAlarm("Alarma programada",21,20)

        }

        btn_A_Localizar_menu.setOnClickListener{
            var intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
        btn_localiza_paciente.setOnClickListener{
            var intent = Intent(this,Ubicar_paciente::class.java)
            startActivity(intent)
        }


    }


    @ExperimentalTime
    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }

        if (intent.resolveActivity(packageManager)  != null) {
            startActivity(intent)

        }

        }



    }


