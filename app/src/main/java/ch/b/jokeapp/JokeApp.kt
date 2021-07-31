package ch.b.jokeapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ch.b.jokeapp.ViewModel.ViewModel

class JokeApp : Application() {
    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        //viewModel = ViewModel(TestModel(BaseResourceManager(this)))
        viewModel = ViewModel(TestModel(BaseResourceManager(this),this))

    }


}