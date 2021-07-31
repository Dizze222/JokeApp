package ch.b.jokeapp.Model

import ch.b.jokeapp.Joke
import ch.b.jokeapp.JokeFailure
import ch.b.jokeapp.customToast


interface Model{
    fun getJoke()

    fun init(callback: ResultCallback)

    fun clear()

    fun testFunction()
}


interface ResultCallback{
    fun provideSuccess(data: Joke)

    fun provideError(error: JokeFailure)

    fun returnToast(toast: customToast)

}