package castro.jhostin.felyapp

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_comentario_blog.*
import java.io.File
import java.io.FileOutputStream

class Comentario_blog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comentario_blog)

    btn_guardar.setOnClickListener{
        guardar_nota();
    }


    }
fun guardar_nota(){
    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 235)
    } else {
        guardar()
    }
}

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            235 -> {
                //pregunta al usuario si acepto los permisos
                if ((grantResults.isNotEmpty()&& grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    guardar()
                } else {
                    Toast.makeText(this,"Error: Permisos denegados", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


    fun guardar(){
        var titulo = et_titulo.text.toString()
        var cuerpo = et_contenido.text.toString()
        if (titulo == "" || cuerpo == ""){
            Toast.makeText(this,"Error: campos vacios",Toast.LENGTH_SHORT).show()
        } else {
            try {
                val archivo = File(ubicacion(),titulo+".txt")
                val fos = FileOutputStream(archivo)
                fos.write(cuerpo.toByteArray())
                fos.close()
                Toast.makeText(
                    this,
                    "Se ah publicado tu comentario",
                    Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                Toast.makeText(this,"Error: no se guardo el archivo", Toast.LENGTH_SHORT).show()
            }
        }
        finish()
    }

    private fun ubicacion(): String {
        var carpeta = File(Environment.getExternalStorageDirectory(),"comentarios")
        if (!carpeta.exists()){
            carpeta.mkdir()
        }
        return carpeta.absolutePath
    }

}
