package valenzuela.isabel.practicapelicula_253301

import android.os.Bundle
import android.widget.ImageView
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
    }

    fun cargarImagenes() {
        ivPortada.setImageResource(R.drawable.portada)
        ivPoster.setImageResource(R.drawable.poster)
    }
}