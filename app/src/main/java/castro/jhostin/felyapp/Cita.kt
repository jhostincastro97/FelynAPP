package castro.jhostin.felyapp

class Cita(
     var id: String,
     var nombreEnfermo: String,
     var cedula: String,
     var direccion: String,
     var telefono: String,
     var clinica: String,
     var numConsultorio: String,
     var fechaCita: String){
     constructor(): this("","","","","","","","")
 }

