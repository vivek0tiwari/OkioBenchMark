package com.example.okiobenchmark

import kotlinx.coroutines.*

class Greeting {
    private val platform: Platform = getPlatform()

     fun greet(path: String): String {
//             write2kbData(path.plus("/f100.txt"),20, 100)
//             write2kbData(path.plus("/f1000.txt"),20, 1000)
//             write2kbData(path.plus("/f10000.txt"), 1,10000)
//            write2kbData(path.plus("/f100000.txt"), 20,100000)


//             readDataLineByLine(path.plus("/f100.txt"))
//             readDataLineByLine(path.plus("/f1000.txt"))
//             readDataLineByLine(path.plus("/f10000.txt"))
             readDataLineByLine(path.plus("/f100000.txt"))
//         write2kbData(path, 1)
//         readDataLineByLine(path, 1)
        return "Hello, ${platform.name}!"
    }
}
