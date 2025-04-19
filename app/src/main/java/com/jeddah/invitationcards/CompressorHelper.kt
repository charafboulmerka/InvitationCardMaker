package com.jeddah.invitationcards

import android.content.Context
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.default
import java.io.File
import id.zelory.compressor.constraint.default
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

object CompressorHelper {
    @JvmStatic
    fun compressImage(context: Context, file: File): File {
        return runBlocking {
            Compressor.compress(context, file)
        }
    }
}