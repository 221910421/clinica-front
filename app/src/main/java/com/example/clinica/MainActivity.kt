package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.clinica.config.AppDatabase
import com.example.clinica.databinding.ActivityMainBinding
import com.example.clinica.models.DoctorModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var database = AppDatabase.getDatabase(this)
            var Doctores = database.doctores().getAll()

            if(Doctores.isEmpty()){
                database.doctores().insert(DoctorModel(0,"Miguel Dominguez", "Odontología", "123456789", "12345678"))
                database.doctores().insert(DoctorModel(0,"Josue Manjarrez", "Cardiología", "12345678", "12345678"))

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                var usuario = binding.txtUser.text.toString()
                var password = binding.txtPassword.text.toString()

                for(i in Doctores){
                    if(i.CedProf == usuario && i.Password == password){
                        val intent = Intent(this, MenuActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }
}