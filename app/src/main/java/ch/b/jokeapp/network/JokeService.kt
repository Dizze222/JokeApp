package ch.b.jokeapp.network


import retrofit2.Call
import retrofit2.http.*

interface JokeService {
   @GET("https://official-joke-api.appspot.com/random_joke/")
   fun getJoke(): Call<JokeDTO>

}