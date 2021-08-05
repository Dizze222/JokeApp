package ch.b.jokeapp.Model

import ch.b.jokeapp.Joke
import ch.b.jokeapp.JokeFailure



interface Model{
    fun getJoke()

    fun init(callback: ResultCallback)

    fun clear()

}



interface ResultCallback{
    fun provideSuccess(data: Joke)

    fun provideError(error: JokeFailure)

}