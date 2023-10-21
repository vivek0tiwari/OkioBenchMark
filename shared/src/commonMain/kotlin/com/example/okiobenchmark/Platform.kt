package com.example.okiobenchmark

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform