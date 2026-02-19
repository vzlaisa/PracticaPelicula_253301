package valenzuela.isabel.practicapelicula_253301

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {

    private lateinit var btnIniciarSesion: Button
    private lateinit var etUsuario: EditText
    private lateinit var etContrasenia: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        etUsuario = findViewById<EditText>(R.id.etUsuario)
        etContrasenia = findViewById<EditText>(R.id.etContrasenia)

        inicializarListeners()
    }

    private fun inicializarListeners() {
        btnIniciarSesion.setOnClickListener {
            iniciarSesion()
        }
    }

    private fun validarInicioDeSesion(): Boolean {
        val usuario = etUsuario.text?.toString()?.trim()
        val contrasenia = etContrasenia.text?.toString()?.trim()

        if (usuario.isNullOrBlank()) {
            etUsuario.error = "El usuario es obligatorio"
            return false
        }

        if (contrasenia.isNullOrBlank()) {
            etContrasenia.error = "La contraseña es obligatoria"
            return false
        }

        return true
    }

    private fun iniciarSesion() {
        if (validarInicioDeSesion()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}