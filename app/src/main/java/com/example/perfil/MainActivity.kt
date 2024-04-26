package com.example.perfil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import com.example.perfil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lat : Double = 0.0
    private var lon: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateUI()
        binding.profileMostrar.setOnClickListener{
            binding.profileMostrar.text = "LAT: $lat, LON: $lon"

        }
    }



    private fun updateUI(name: String = "Curso UV",
                         correo: String = "yahirlagunesceballos@gmail.com",
                         web : String = "https://yahirlagunes1.com",
                         phone: String = "+52 22 99 50 75 38",
                         ){
        binding.profileTvNombre.text = name
        binding.profileTvCorreo.text = correo
        binding.profileTvWeb.text = web
        binding.profileTvPhone.text = phone
        lat = 19.1412579
        lon = -96.3937088
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    private val editResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_CANCELED){
            val name = it.data?.getStringExtra("k_name")
            val correo = it.data?.getStringExtra("k_correo")
            val phone = it.data?.getStringExtra("k_phone")
            val web = it.data?.getStringExtra("k_web")

            lon = it.data?.getStringExtra("k_lon")?.toDouble() ?:0.0
            lat = it.data?.getStringExtra("k_lat")?.toDouble() ?:0.0
            updateUI(name!!,correo!!,web!!,phone!!)
        }
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_edit){
            startActivity(Intent(this,EditActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_edit)

    }*/ */


}