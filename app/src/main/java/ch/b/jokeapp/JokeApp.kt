package ch.b.jokeapp

import android.app.Application
import ch.b.jokeapp.Model.BaseModel
import ch.b.jokeapp.ViewModel.ViewModel
import ch.b.jokeapp.network.JokeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeApp : Application() {
    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://official-joke-api.appspot.com/random_joke/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        viewModel = ViewModel(BaseModel(retrofit.create(JokeService::class.java),BaseResourceManager(this)))
    }
}