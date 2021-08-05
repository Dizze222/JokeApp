package ch.b.jokeapp.network

import ch.b.jokeapp.Joke
import com.google.gson.annotations.SerializedName

data class JokeDTO(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("type")
    private val type: String,
    @SerializedName("setup")
    private val text: String,
    @SerializedName("punchline")
    private val punchLine: String
){
    fun toJoke() = Joke(text,punchLine)
}
