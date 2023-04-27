package com.example.firebase_realtime_icm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActiviy : AppCompatActivity() {

    lateinit var edtname:EditText
    lateinit var edtEmail:EditText
    lateinit var edtPass:EditText
    lateinit var btncreate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activiy)

        edtname= findViewById(R.id.edtname)
        edtEmail= findViewById(R.id.edtEmail)
        edtPass= findViewById(R.id.edtPass)
        btncreate= findViewById(R.id.btncreate)

        btncreate.setOnClickListener {



        }
    }
}