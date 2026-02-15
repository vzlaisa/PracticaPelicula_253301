package valenzuela.isabel.practicapelicula_253301

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var ivPortada : ImageView
    lateinit var ivPoster : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ivPortada = findViewById(R.id.ivPortada)
        ivPoster = findViewById(R.id.ivPoster)

        cargarImagenes()
        cargarGeneros()
    }

    private fun cargarImagenes() {
        ivPortada.setImageResource(R.drawable.portada)
        ivPoster.setImageResource(R.drawable.poster)
    }

    private fun cargarGeneros() {
        val generos = listOf("Comedia", "Comedia de zombies", "Fantasía", "Comedia de terror", "Aventuras", "Familiar", "Cine de fantasmas")

        val layout = findViewById<com.google.android.flexbox.FlexboxLayout>(R.id.lGeneros)

        for (genero in generos) {
            val tv = TextView(this)
            tv.text = genero

            tv.setTextAppearance(R.style.textoGeneroPelicula)

            // Agregar margenes entre los items usando FlexboxLayoutParams
            val params = com.google.android.flexbox.FlexboxLayout.LayoutParams(
                com.google.android.flexbox.FlexboxLayout.LayoutParams.WRAP_CONTENT,
                com.google.android.flexbox.FlexboxLayout.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(40, 8, 40, 8)
            tv.layoutParams = params

            layout.addView(tv)
        }
    }
}