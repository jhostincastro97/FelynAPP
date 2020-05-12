package castro.jhostin.felyapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_blog_interactivo.*
import kotlinx.android.synthetic.main.activity_cardiologia.*
import kotlinx.android.synthetic.main.comentario_layout.view.*
import java.io.*
import java.lang.Exception

class BlogInteractivo : AppCompatActivity() {
    var comentarios = ArrayList<Comentario>()
    lateinit var adaptador: AdaptadorComentario


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_interactivo)

        //boton atras a menu principal
        btn_A_Blog_menu.setOnClickListener {
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        //boton para agregar un nuevo comentario en el blog
        fab.setOnClickListener {
            var intent = Intent(this, Comentario_blog::class.java)
            startActivityForResult(intent, 123)
        }

        leerNotas()

        adaptador = AdaptadorComentario(this, comentarios)
        listview.adapter = adaptador
    }


    fun leerNotas() {
        comentarios.clear()
        var carpeta = File(ubicacion().absolutePath)

        if (carpeta.exists()) {
            var archivos = carpeta.listFiles()
            if (archivos != null) {
                for (archivo in archivos) {
                    leerArchivo(archivo)
                }
            }
        }
    }


    fun leerArchivo(archivo: File) {
        val fis = FileInputStream(archivo)
        val di = DataInputStream(fis)
        val br = BufferedReader(InputStreamReader(di))
        var strLine: String? = br.readLine()
        var myData = ""

        // lee los archivos almacenados en la memoria
        while (strLine != null) {
            myData = myData + strLine
            strLine = br.readLine()
        }
        br.close()
        di.close()
        fis.close()
        // elimina el .txt
        var nombre = archivo.name.substring(0, archivo.name.length - 4)
        //crea la nota y la agrega a la lista
        var comentario = Comentario(nombre, myData)
        comentarios.add(comentario)
    }


    private fun ubicacion(): File {
        val folder = File(Environment.getExternalStorageDirectory(), "comentarios")
        if (!folder.exists()) {
            folder.mkdir()
        }
        return folder
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //se activa cuando se regresa del agregarNotaActivity
        if (requestCode == 123) {
            leerNotas()
            adaptador.notifyDataSetChanged()
        }


    }


    class AdaptadorComentario : BaseAdapter {
        var context: Context
        var comentarios = ArrayList<Comentario>()

        constructor(context: Context, comentario: ArrayList<Comentario>) {
            this.context = context
            this.comentarios = comentario
        }

        @SuppressLint("ViewHolder")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var inflador = LayoutInflater.from(context)
            var vista = inflador.inflate(R.layout.comentario_layout, null)
            var comentario = comentarios[p0]

            vista.tv_titulo_detalleN.text = comentario.titulo
            vista.tv_contenido_nota.text = comentario.contenido

            vista.btn_borrar.setOnClickListener {
                eliminar(comentario.titulo)
                comentarios.remove(comentario)
                this.notifyDataSetChanged()
            }
            return vista
        }


        override fun getItem(p0: Int): Any {
            return comentarios[p0]
        }

        override fun getItemId(p0: Int): Long {
        return p0.toLong()
        }

        override fun getCount(): Int {
            return comentarios.size
        }

        private fun eliminar(titulo: String) {
            if (titulo == "") {
                Toast.makeText(context, "Error titulo vacio", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    // elimina el archivo con el titulo seleccionado
                    val archivo = File(ubicacion(), titulo + ".txt")
                    archivo.delete()
                    Toast.makeText(context, "Se elimino el comentario", Toast.LENGTH_SHORT).show()

                } catch (e: Exception) {
                    Toast.makeText(context, "Error al eliminar el archivo", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        private fun ubicacion(): String {
            val album = File(Environment.getExternalStorageDirectory(), "comentarios")
            if (!album.exists()) {
                album.mkdir()
            }
            return album.absolutePath
        }

    }
}
