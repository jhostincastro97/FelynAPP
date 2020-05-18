package castro.jhostin.felyapp

import java.util.*

data class Cita(var id: UUID,
                var nombreEnfermo: String,
                var cedula: String,
                var direccion: String,
                var telefono: String,
                var clinica: String,
                var numConsultorio: String,
                var fechaCita: String)