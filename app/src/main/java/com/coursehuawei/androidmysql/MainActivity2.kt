package com.coursehuawei.androidmysql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity2 : AppCompatActivity() {
    var txtNombre: EditText?=null
    var txtEmail: EditText?=null
    var txtTelefono: EditText?=null
    var txtPassword: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //        inicializar textos
        txtNombre=findViewById(R.id.txtNombre)
        txtEmail=findViewById(R.id.txtEmail)
        txtTelefono=findViewById(R.id.txtTelefono)
        txtPassword=findViewById(R.id.txtPassword)

//        recibir datos
        val id=intent.getStringExtra("id").toString()

        val queue=Volley.newRequestQueue(this)
        val url="http://192.168.0.7/android_mysql/registro.php?id=$id"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                txtNombre?.setText(response.getString("nombre"))
                txtEmail?.setText(response.getString("email"))
                txtTelefono?.setText(response.getString("telefono"))
                txtPassword?.setText(response.getString("password"))
            },
            { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }
        )
        queue.add(jsonObjectRequest)
    }
    fun clickRegresar(view:View){
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}