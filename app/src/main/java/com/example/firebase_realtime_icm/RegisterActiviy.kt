package com.example.firebase_realtime_icm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActiviy : AppCompatActivity() {

    lateinit var edtname: EditText
    lateinit var edtEmail: EditText
    lateinit var edtPass: EditText
    lateinit var btncreate: Button

    //initialize firebase
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activiy)

        edtname = findViewById(R.id.edtname)
        edtEmail = findViewById(R.id.edtEmail)
        edtPass = findViewById(R.id.edtPass)
        btncreate = findViewById(R.id.btncreate)

        //calling the firebase
        auth = FirebaseAuth.getInstance()
        btncreate.setOnClickListener {

            var name = edtname.text.toString().trim()
            var email = edtEmail.text.toString().trim()
            var password = edtPass.text.toString().trim()

            //validate user info

            if (name.isEmpty() || email.isEmpty() || password.isEmpty())
                Toast.makeText(this, "CANNOT SUBMIT AN EMPTY FIELD", Toast.LENGTH_SHORT).show()
            else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "USER CREATED SUCCESSFULLY", Toast.LENGTH_SHORT).show()

                        var gotolog = Intent(this, LoginActivity::class.java)
                        startActivity(gotolog)
                    } else {

                        Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                        Log.d("TAG", "error---->", it.exception)

                    }
                }
            }


        }
    }
}


