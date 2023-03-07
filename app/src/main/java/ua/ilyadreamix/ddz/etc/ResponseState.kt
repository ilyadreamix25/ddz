package ua.ilyadreamix.ddz.etc

enum class ResponseState {
    Idle, Loading, Error, Success
}

data class ResponseStateModel<T>(
    val state: ResponseState = ResponseState.Idle,
    val data: T? = null
)
