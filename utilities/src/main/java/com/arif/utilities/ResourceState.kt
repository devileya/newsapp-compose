package com.arif.utilities

sealed class ResourceState <T> {
    class Loading<T> : ResourceState<T>()
    class Success<T>(val data: T) : ResourceState<T>()
    class Error<T>(val message: String) : ResourceState<T>()
}