package castro.jhostin.felyapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE $TABLE_NAME " +
                    "($COLUMN_ID INTEGER PRIMARY KEY, " +
                    "$COLUMN_NOMBRE TEXT, " +
                    "$COLUMN_EDAD TEXT," +
                    "$COLUMN_ENFERMEDAD TEXT, " +
                    "$COLUMN_GRADO_ENFERMEDAD TEXT," +
                    "$COLUMN_TIPO_DE_SANGRE TEXT," +
                    "$COLUMN_ESTATURA TEXT," +
                    "$COLUMN_PESO TEXT," +
                    "$COLUMN_ALERGIAS TEXT," +
                    "$COLUMN_SERVICIO_MEDICO TEXT," +
                    "$COLUMN_NUMERO_SEGURO_SOCIAL TEXT," +
                    "$COLUMN_DIAGNOSTICO TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertRow(name: String, age:String, enfermedad: String,grado_enfermedad:String,tipo_de_sangre:String,estatura:String
                 ,peso:String,alergias:String,servicio_medico:String,no_seguro_social:String,diagnostico_medico:String) {
        val values = ContentValues()
        values.put(COLUMN_NOMBRE, name)
        values.put(COLUMN_EDAD, age)
        values.put(COLUMN_ENFERMEDAD, enfermedad)
        values.put(COLUMN_GRADO_ENFERMEDAD, grado_enfermedad)
        values.put(COLUMN_TIPO_DE_SANGRE, tipo_de_sangre)
        values.put(COLUMN_ESTATURA, estatura)
        values.put(COLUMN_PESO, peso)
        values.put(COLUMN_ALERGIAS, alergias)
        values.put(COLUMN_SERVICIO_MEDICO, servicio_medico)
        values.put(COLUMN_NUMERO_SEGURO_SOCIAL,no_seguro_social)
        values.put(COLUMN_DIAGNOSTICO, diagnostico_medico)


        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updateRow(row_id: String,name: String, age:String, enfermedad: String,grado_enfermedad:String,tipo_de_sangre:String,estatura:String
                  ,peso:String,alergias:String,servicio_medico:String,no_seguro_social:String,diagnostico_medico:String) {
        val values = ContentValues()
        values.put(COLUMN_NOMBRE, name)
        values.put(COLUMN_EDAD, age)
        values.put(COLUMN_ENFERMEDAD, enfermedad)
        values.put(COLUMN_GRADO_ENFERMEDAD, grado_enfermedad)
        values.put(COLUMN_TIPO_DE_SANGRE, tipo_de_sangre)
        values.put(COLUMN_ESTATURA, estatura)
        values.put(COLUMN_PESO, peso)
        values.put(COLUMN_ALERGIAS, alergias)
        values.put(COLUMN_SERVICIO_MEDICO, servicio_medico)
        values.put(COLUMN_NUMERO_SEGURO_SOCIAL,no_seguro_social)
        values.put(COLUMN_DIAGNOSTICO, diagnostico_medico)

        val db = this.writableDatabase
        db.update(TABLE_NAME, values, "$COLUMN_ID = ?", arrayOf(row_id))
        db.close()
    }

    fun deleteRow(row_id: String) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_ID = ?", arrayOf(row_id))
        db.close()
    }

    fun getAllRow(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "myDBfile.db"
        const val TABLE_NAME = "users"

        const val COLUMN_ID = "id"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_EDAD = "edad"
        const val COLUMN_ENFERMEDAD = "enfermedad"
        const val COLUMN_GRADO_ENFERMEDAD = "grado_de_enfermedad"
        const val COLUMN_TIPO_DE_SANGRE = "tipo_de_sangre"
        const val COLUMN_ESTATURA = "estatura"
        const val COLUMN_PESO = "peso"
        const val COLUMN_ALERGIAS = "alergias"
        const val COLUMN_SERVICIO_MEDICO = "servicio_medico"
        const val COLUMN_NUMERO_SEGURO_SOCIAL = "numero_seguro_social"
        const val COLUMN_DIAGNOSTICO = "diagnostico_medico"







    }


}