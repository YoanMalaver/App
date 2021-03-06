package com.coursehuawei.androidmysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    var txtNombre:EditText?=null
    var txtEmail:EditText?=null
    var txtTelefono:EditText?=null
    var txtPassword:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        inicializar textos
        setContentView(R.layout.activity_main)
        txtNombre=findViewById(R.id.txtNombre)
        txtEmail=findViewById(R.id.txtEmail)
        txtTelefono=findViewById(R.id.txtTelefono)
        txtPassword=findViewById(R.id.txtPassword)
    }
    fun clickBtnInsertar(view:View){
        val url="http://192.168.0.6/android_mysql/insertar.php"
        val queue= Volley.newRequestQueue(this)
        var resultadoPost = object : StringRequest(Request.Method.POST,url,
            Response.Listener<String> { response ->
                Toast.makeText(this, "Usuario insertado Exitosamente", Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error  ->
                Toast.makeText(this, "Error $error", Toast.LENGTH_LONG).show()
            }){
            override fun getParams(): MutableMap<String, String> {
                val parametros=HashMap<String, String>()
                parametros.put("nombre", txtNombre?.text.toString())
                parametros.put("email", txtEmail?.text.toString())
                parametros.put("telefono", txtTelefono?.text.toString())
                parametros.put("password", txtPassword?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)
    }
}