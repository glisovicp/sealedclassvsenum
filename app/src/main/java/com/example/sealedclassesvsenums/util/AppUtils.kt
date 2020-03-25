package com.example.sealedclassesvsenums.util

import com.example.sealedclassesvsenums.BuildConfig

class AppUtils {

    companion object {

        fun getApplicationVersion() : String = "${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})"
    }
}