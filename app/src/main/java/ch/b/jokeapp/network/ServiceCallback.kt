package ch.b.jokeapp.network

interface ServiceCallback {
    fun returnSuccess(data: JokeDTO)

    fun returnError(type: ErrorType)
}

interface TextCallback {
    fun provideText(text: String)
}
