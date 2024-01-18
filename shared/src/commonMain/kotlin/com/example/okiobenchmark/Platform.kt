package com.example.okiobenchmark

interface Platform {
    val name: String
}
interface  TestResult {
    val testName: String
    val timeTaken: Number
}

expect fun getPlatform(): Platform

expect fun write2kbData(path: String, batchSize: Int =1, iteration: Int =1) : Unit
expect fun readDataLineByLine(path: String, batchSize: Int =1) : Unit