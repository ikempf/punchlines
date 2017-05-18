package com.punchlines.punchline.paas

import java8.util.concurrent.CompletableFuture

class PaasService(private val repository: PaasRepository) {

    fun dailyPunchline(): CompletableFuture<Punchline> =
        repository.dailyPunchline()

    fun randomPunchline(): CompletableFuture<Punchline> =
        repository.randomPunchline()

    fun artists(): CompletableFuture<List<String>> =
        repository.artists()

    fun artistPunchlines(artist: String): CompletableFuture<List<Punchline>> =
        repository.artistPunchlines(artist)

}