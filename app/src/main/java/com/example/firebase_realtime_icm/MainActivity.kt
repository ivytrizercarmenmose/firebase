package com.example.firebase_realtime_icm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var data : EditText
    lateinit var btnsave:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = findViewById(R.id.data)
        btnsave=findViewById(R.id.btnsave)

        var database =FirebaseDatabase.getInstance()
        var databaseref = database.reference

        btnsave.setOnClickListener {

            var user_data = data.text.toString().trim()
            databaseref.setValue(user_data)

            //Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
        }
    }
}