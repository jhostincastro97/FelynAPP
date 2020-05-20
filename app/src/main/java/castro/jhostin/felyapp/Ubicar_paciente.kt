package castro.jhostin.felyapp

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class Ubicar_paciente : AppCompatActivity(), OnMapReadyCallback {
    //variables para permiso de ubicacion actual
    private val permisoFineLocation = android.Manifest.permission.ACCESS_FINE_LOCATION
    private val CODIGO_SOLICITUD_PERMISO = 100
    private var fusedLocationClient:   FusedLocationProviderClient? = null
    var locationRequest: LocationRequest? = null

    private var callback: LocationCallback? = null

    private lateinit var mMap: GoogleMap

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubicar_paciente)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    fusedLocationClient = FusedLocationProviderClient(this)
    inicializarLocationRequest()

        callback = object: LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)
                if(mMap != null){
                    mMap.isMyLocationEnabled = true
                    mMap.uiSettings.isMyLocationButtonEnabled = true
                    if (locationResult != null) {
                        for (ubicacion in locationResult.locations){
                            val mi_Ubicacion = LatLng(ubicacion.latitude,ubicacion.longitude)
                            mMap.addMarker(MarkerOptions().position(mi_Ubicacion).title("Aqui estoy"))
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(mi_Ubicacion))
                        }
                    }
                }


            }
        }

    }

    private fun inicializarLocationRequest(){
        locationRequest = LocationRequest()
        locationRequest?.interval = 10000
        locationRequest?.fastestInterval = 5000
        locationRequest?.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        //mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        val estiloMapa = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.estilo_mapa))
    }
    fun validarPermisosUbicacion():Boolean{

        return ActivityCompat.checkSelfPermission(this, permisoFineLocation)== PackageManager.PERMISSION_GRANTED
    }


    private fun obtenerUbicacion(){

        fusedLocationClient?.requestLocationUpdates(locationRequest,callback, null)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun pedirPermisos(){
        val deboProveerContexto = ActivityCompat.shouldShowRequestPermissionRationale(this,permisoFineLocation)
        if (deboProveerContexto){
            //mandar mensaje con explicacion adiccional
            solicitudPermiso()
        }else {
            solicitudPermiso()
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun solicitudPermiso(){
        requestPermissions(arrayOf(permisoFineLocation),CODIGO_SOLICITUD_PERMISO)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CODIGO_SOLICITUD_PERMISO ->{
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    obtenerUbicacion()
                }else{
                    Toast.makeText(this,"No diste permiso para acceder a la ubicacion",Toast.LENGTH_LONG).show()
                }
            }



        }
    }


    private fun obtenerActualizacionUbicacion(){
        fusedLocationClient?.removeLocationUpdates(callback)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()

        if (validarPermisosUbicacion()){
            obtenerUbicacion()
        }else{
            pedirPermisos()
        }
    }

    override fun onPause() {
        super.onPause()
        obtenerActualizacionUbicacion()
    }



}
