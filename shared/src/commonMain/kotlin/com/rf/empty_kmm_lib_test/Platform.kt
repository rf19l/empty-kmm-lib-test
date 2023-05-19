package com.rf.empty_kmm_lib_test

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform