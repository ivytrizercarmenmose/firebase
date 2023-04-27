package com.example.firebase_realtime_icm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

class LoginActivity : AppCompatActivity() {

    lateinit var edtemail:EditText
    lateinit var edtpass:EditText
    lateinit var btnlog:Button
    lateinit var btnreg:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtemail=findViewById(R.id.edtemail)
        edtpass=findViewById(R.id.edtpass)
        btnlog=findViewById(R.id.btnlog)
        btnreg= findViewById(R.id.btnreg)


        btnlog.setOnClickListener {
        //

        }

        btnreg.setOnClickListener {

            //nav user to registration page
            val reg = Intent(this,RegisterActiviy::class.java)
            startActivity(reg)

        }
    }
}