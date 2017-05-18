package com.punchlines.punchline.paas

import java8.util.concurrent.CompletableFuture
import retrofit2.http.GET
import retrofit2.http.Path

import com.punchlines.configuration.Configuration.ARTISTS
import com.punchlines.configuration.Configuration.ARTIST_ARGUMENT
import com.punchlines.configuration.Configuration.ARTIST_PUNCHLINES
import com.punchlines.configuration.Configuration.DAILY
import com.punchlines.configuration.Configuration.RANDOM

interface PaasRepository {

    @GET(DAILY)
    fun dailyPunchline(): CompletableFuture<Punchline>

    @GET(RANDOM)
    fun randomPunchline(): CompletableFuture<Punchline>

    @GET(ARTISTS)
    fun artists(): CompletableFuture<List<String>>

    @GET(ARTIST_PUNCHLINES)
    fun artistPunchlines(@Path(ARTIST_ARGUMENT) artist: String): CompletableFuture<List<Punchline>>

}