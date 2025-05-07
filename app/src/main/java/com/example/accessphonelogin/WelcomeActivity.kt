package com.example.accessphonelogin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val usuario = intent.getStringExtra("usuario")
        val textView = findViewById<TextView>(R.id.textViewWelcome)
        textView.text = "¡Bienvenida, $usuario!"
    }
}
