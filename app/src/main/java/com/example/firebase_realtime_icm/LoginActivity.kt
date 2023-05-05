package com.example.firebase_realtime_icm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var edtemail:EditText
    lateinit var edtpass:EditText
    lateinit var btnlog:Button
    lateinit var btnreg:Button
    
    //initialize firebase
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtemail=findViewById(R.id.edtemail)
        edtpass=findViewById(R.id.edtpass)
        btnlog=findViewById(R.id.btnlog)
        btnreg= findViewById(R.id.btnreg)
        
        //calling firebase
        auth= FirebaseAuth.getInstance()


        btnlog.setOnClickListener {
        //
var email = edtemail.text.toString().trim()
var password = edtpass.text.toString().trim()

            
            if (email.isEmpty()||password.isEmpty())

                Toast.makeText(this, "cannot submit an empty field", Toast.LENGTH_SHORT).show()
            
            else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                        var gotomain=Intent(this,MainActivity::class.java )
                        startActivity(gotomain)
                        finish()
                        
                    }else{
                        Toast.makeText(this, "check entries", Toast.LENGTH_SHORT).show()
                    }
                }
                
                
            }
        }

        btnreg.setOnClickListener {

            //nav user to registration page
            val reg = Intent(this,RegisterActiviy::class.java)
            startActivity(reg)

        }
    }
}