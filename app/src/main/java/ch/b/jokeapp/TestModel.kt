package ch.b.jokeapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ch.b.jokeapp.Model.Model
import ch.b.jokeapp.Model.ResultCallback

class TestModel(resourceManager: ResourceManager, application: Application) : Model,AndroidViewModel(application) {
    private var callback: ResultCallback? = null
    private val noConnection = NoConnection(resourceManager)
    private val servieUnavalide = ServiceUnavailable(resourceManager)
    private var count = 0

    override fun getJoke() {
        Thread {
            Thread.sleep(1000)
            when(count){
                0 -> callback?.provideSuccess(Joke("testText","testPunchline"))
                1 -> callback?.provideError(noConnection)
                2 -> callback?.provideError(servieUnavalide)
            }
            count++
            if(count == 3) count = 0

        }.start()

    }

    override fun init(callback: ResultCallback) {
        this.callback = callback
    }

    override fun clear() {
        callback = null
    }



}