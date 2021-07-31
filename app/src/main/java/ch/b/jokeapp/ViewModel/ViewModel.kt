package ch.b.jokeapp.ViewModel

import ch.b.jokeapp.Joke
import ch.b.jokeapp.JokeFailure
import ch.b.jokeapp.Model.Model
import ch.b.jokeapp.Model.ResultCallback
import ch.b.jokeapp.customToast

class ViewModel(private val model: Model) {
    private var callback: TextCallback? = null


    fun init(callback: TextCallback) {
        this.callback = callback
        model.init(object : ResultCallback {
            override fun provideSuccess(data: Joke) = callback.provideText(data.getJokeUi())

            override fun provideError(error: JokeFailure) = callback.provideText(error.getMessage())

            override fun returnToast(toast: customToast) {

            }
        })
    }

    fun getJoke() {
        model.getJoke()
    }

    fun clear() {
        callback = null
        model.clear()
    }
    fun testFun(){
        model.testFunction()
    }


}

interface TextCallback {
    fun provideText(text: String)
}