package com.example.okiobenchmark

import java.io.IOException
import java.nio.file.FileSystem

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()
