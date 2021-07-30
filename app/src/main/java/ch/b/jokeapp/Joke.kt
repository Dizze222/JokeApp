package ch.b.jokeapp

import android.content.Context
import androidx.annotation.StringRes

class Joke(private val text: String,private val punchLine: String) {

    fun getJokeUi() = "$text\n$punchLine"
}

    interface JokeFailure {
        fun getMessage(): String
    }

    class NoConnection(private val resourceManager: ResourceManager) : JokeFailure {
        override fun getMessage(): String = resourceManager.getString(R.string.no_connection)


    }

    class ServiceUnavailable(private val resourceManager: ResourceManager) : JokeFailure {
        override fun getMessage(): String = resourceManager.getString(R.string.service_unavailable)

    }

    interface ResourceManager {
        fun getString(@StringRes stringResId: Int): String
    }
    class BaseResourceManager(private val context: Context) : ResourceManager{
        override fun getString(stringResId: Int): String = context.getString(stringResId)

    }


