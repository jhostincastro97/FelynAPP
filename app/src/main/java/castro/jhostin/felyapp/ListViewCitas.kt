package castro.jhostin.felyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_list_view_citas.*

class ListViewCitas : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var listaCitas: MutableList<Cita>
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_citas)
        listaCitas = mutableListOf()
        listView = findViewById(R.id.listview_citas)
        ref = FirebaseDatabase.getInstance().getReference("citas")

        ref.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    listaCitas.clear()
                    for(c in p0.children){
                        val cita = c.getValue(Cita::class.java)
                        listaCitas.add(cita!!)
                    }
                    val adapter = CitaAdapter(applicationContext, R.layout.citas, listaCitas)
                    listView.adapter = adapter
                }
            }

        })
        btnMenu.setOnClickListener {
            var intent = Intent(this, CategoriasCitas::class.java)
            startActivity(intent)
        }
    }
}
