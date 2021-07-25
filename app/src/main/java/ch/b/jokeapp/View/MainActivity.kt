package ch.b.jokeapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.b.jokeapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}