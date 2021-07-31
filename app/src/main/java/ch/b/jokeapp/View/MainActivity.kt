package ch.b.jokeapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import ch.b.jokeapp.JokeApp
import ch.b.jokeapp.R
import ch.b.jokeapp.ViewModel.TextCallback
import ch.b.jokeapp.ViewModel.ViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        viewModel = (application as JokeApp).viewModel
        val button = findViewById<Button>(R.id.button)
        val buttonTest = findViewById<Button>(R.id.buttonTest)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textView = findViewById<TextView>(R.id.textView)
        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            viewModel.getJoke()
        }
        buttonTest.setOnClickListener {
            viewModel.testFun()
        }


        viewModel.init(object : TextCallback {
            override fun provideText(text: String) = runOnUiThread {
                button.isEnabled = true
                progressBar.visibility = View.INVISIBLE
                textView.text = text
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}