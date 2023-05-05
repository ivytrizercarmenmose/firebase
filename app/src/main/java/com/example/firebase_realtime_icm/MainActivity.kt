package com.example.firebase_realtime_icm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var carmake : EditText
    lateinit var model : EditText
    lateinit var price : EditText

    lateinit var btn_view:Button
    lateinit var btn_photo:Button
    lateinit var btn_cardata:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carmake = findViewById(R.id.edt_carmake)
        model = findViewById(R.id.edt_carmodel)
        price = findViewById(R.id.edt_carprice)

        btn_view=findViewById(R.id.btnviewcars)
        btn_photo=findViewById(R.id.btnphoto)
        btn_cardata=findViewById(R.id.btncardata)

        var database =FirebaseDatabase.getInstance()




        //uploading photo
        btn_photo.setOnClickListener {
        }

        //upload cardata
        btn_cardata.setOnClickListener {
            var carmake_ = carmake.text.toString().trim()
            var model_ = model.text.toString().trim()
            var price_ = price.text.toString().trim()

            var id = System.currentTimeMillis().toString()

            var databaseref = database.getReference("cars/"+id)


            if (carmake_.isEmpty()||model_.isEmpty()||price_.isEmpty())
                Toast.makeText(this, "Cannot Submit An Empty Field ", Toast.LENGTH_SHORT).show()
            else{
                //try to upload data to firebase
            var usercar = Cars(carmake_,model_,price_,id)

                var ref = FirebaseDatabase.getInstance().getReference().child("cars")

                ref.setValue(usercar).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this, "car data uploaded successfully", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this, "Car Data Upload not Successfull", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }
        //viewing uploaded data
        btn_view.setOnClickListener {

        var viewcars= Intent(this,view_cars::class.java)
        startActivity(viewcars)
        }

        }









}